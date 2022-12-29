package com.example.kt6_imagelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kt6_imagelist.databinding.ItemImageListBinding

class ImageAdapter(private var list : ArrayList<Int> , private val selectedListener : ((uri : Int) -> Unit)? , private val deleteListener : ((uri : Int) -> Unit)?) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemImageListBinding.inflate(LayoutInflater.from(
            parent.context) ,
            parent ,
            false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(private var binding: ItemImageListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uri : Int) {
            binding.imageView.setBackgroundResource(uri)
            binding.imageView.setOnClickListener{
                if (binding.showBack.visibility == View.GONE) {
                    binding.showBack.visibility = View.VISIBLE
                    selectedListener?.let { it1 -> it1(uri) }
                } else {
                    binding.showBack.visibility = View.GONE
                    deleteListener?.let { it1 -> it1(uri) }
                }
            }

        }
    }
}