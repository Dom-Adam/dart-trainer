package com.example.darttrainer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.darttrainer.databinding.DisplayGameBinding
import com.example.darttrainer.models.GameModel

class DisplayGamesAdapter(
    private val listener: OnItemClickListener,
    private val dataSet: List<GameModel>
) :
    RecyclerView.Adapter<DisplayGamesAdapter.TrainingGameViewHolder>() {

    inner class TrainingGameViewHolder(val binding: DisplayGameBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(item: GameModel) {
            binding.viewModel = item
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(binding.viewModel!!.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingGameViewHolder {
        return TrainingGameViewHolder(
            DisplayGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TrainingGameViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    interface OnItemClickListener {
        fun onItemClick(game: String)
    }
}
