package kz.evertume.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.evertume.cats.databinding.CatBinding

class CatAdapter : ListAdapter<Cat, CatAdapter.CatViewHolder>(CatsDiffUtil()) {


    class CatsDiffUtil:DiffUtil.ItemCallback<Cat>(){
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CatBinding.inflate(layoutInflater, parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CatViewHolder(private val binding: CatBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(catBreed: Cat) {
            with(binding) {
                catName.text = catBreed.name
                catOrigin.text = "Origin: ${catBreed.origin}"
                catIntelligence.text = "Intelligence: ${catBreed.intelligence}"
                catLifeExpectancy.text = "Life Expectancy: ${catBreed.minLifeExpectancy}-${catBreed.maxLifeExpectancy} years"

                Glide.with(catImage.context)
                    .load(catBreed.imageLink)
                    .placeholder(R.drawable.cat_placeholder)
                    .into(catImage)
            }
        }
    }
}
