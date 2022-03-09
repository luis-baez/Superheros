package com.superheros.ui.main.superheros.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.superheros.R
import com.superheros.core.domain.Superhero
import com.superheros.databinding.HeroRowBinding
import kotlin.properties.Delegates


typealias onSuperheroClick = (Superhero) -> Unit

class SuperheroAdapter(private val onSuperheroClick: onSuperheroClick) :
    RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    var items: List<Superhero> by Delegates.observable(emptyList(), { _, _, _ ->
        notifyDataSetChanged()
        noOfItems = items.size
    })

    var noOfItems = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return fromParent(parent)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        items.isNotEmpty().let {
            if (it) {
                val itemsRange = 1 until items.size
                when (itemsRange.contains(position % noOfItems)) {
                    true -> {
                        holder.bind(items[position % noOfItems])
                    }
                    else -> {
                        holder.bind(items[0])
                    }
                }
            }
        }

    }


    inner class SuperheroViewHolder(
        private val binding: HeroRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(superhero: Superhero) {
            binding.run {
                container.setOnClickListener {
                    onSuperheroClick.invoke(superhero)
                }
                tvName.text = superhero.name
                Glide.with(binding.root.context)
                    .load("${superhero.thumbnail?.path}.${superhero.thumbnail?.extension}")
                    .into(image)
            }
        }

    }

    fun fromParent(parent: ViewGroup): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_row, parent, false)
        return SuperheroViewHolder(HeroRowBinding.bind(view))
    }

}