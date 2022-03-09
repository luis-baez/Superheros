package com.superheros.ui.main.superheros.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.superheros.R
import com.superheros.databinding.FragmentSuperheroDetailBinding
import com.superheros.ui.main.superheros.fragment.SuperheroDetailFragmentArgs


class SuperheroDetailFragment : Fragment(R.layout.fragment_superhero_detail) {

    private lateinit var binding: FragmentSuperheroDetailBinding
    private val args: SuperheroDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSuperheroDetailBinding.bind(view).apply {
            lifecycleOwner = this@SuperheroDetailFragment
        }

        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl(args.urlDetail)
    }

}