package com.example.darttrainer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.darttrainer.databinding.CategoryItemBinding
import com.example.darttrainer.models.CategoryModel

class HomeAdapter(
    private val dataSet: Array<CategoryModel>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(item: CategoryModel) {
            binding.model = item
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(binding.model!!.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(layoutInflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size

    interface OnItemClickListener {
        fun onItemClick(category: String)
    }
}