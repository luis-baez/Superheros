package com.superheros.ui.main.superheros.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.superheros.R
import com.superheros.databinding.FragmentSuperherosBinding
import com.superheros.ui.main.superheros.adapter.SuperheroAdapter
import com.superheros.ui.main.superheros.fragment.SuperherosFragmentDirections
import com.superheros.ui.main.superheros.viewmodel.SuperherosViewModel
import com.superheros.ui.utils.BaseUiModel
import com.superheros.ui.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SuperherosFragment : Fragment(R.layout.fragment_superheros) {


    private val superherosViewModel: SuperherosViewModel by viewModels()
    private lateinit var binding: FragmentSuperherosBinding
    private lateinit var navController: NavController

    private val superheroAdapter =
        SuperheroAdapter { superhero ->
            superhero.urls?.let {
                it.listIterator().next().url?.let { url ->
                    navController.navigate(
                        SuperherosFragmentDirections.actionSuperheroesFragmentToDetailFragment(
                            url,
                            superhero.name!!
                        )
                    )
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperherosBinding.inflate(inflater, container, false).apply {
            viewModel = superherosViewModel
            lifecycleOwner = this@SuperherosFragment
        }
        navController = findNavController()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSuperheros.apply {
            adapter = superheroAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

        binding.swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            superherosViewModel.getsuperheros()
        })
        observeSuperheros()
        superherosViewModel.getsuperheros()

    }


    private fun observeSuperheros() {
        superherosViewModel.superheros.observe(viewLifecycleOwner, EventObserver { model ->

            if (binding.swipeContainer.isRefreshing) {
                binding.swipeContainer.isRefreshing = false
            }

            when (model) {
                is BaseUiModel.Success -> {
                    superheroAdapter.items = model.data
                }
                is BaseUiModel.Error -> {
                    Log.e("SuperherosFragment", model.error)
                }
                is BaseUiModel.ErrorEx -> {
                    Log.e("SuperherosFragment", model.ex.toString())
                }
            }
        })
    }
}