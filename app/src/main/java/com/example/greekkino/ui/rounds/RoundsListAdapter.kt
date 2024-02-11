package com.example.greekkino.ui.rounds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.greekkino.data.models.ui.Round
import com.example.greekkino.databinding.ItemRoundBinding

object RoundsUtils : DiffUtil.ItemCallback<Round>() {

    override fun areItemsTheSame(
        oldItem: Round,
        newItem: Round
    ) = oldItem.drawId == newItem.drawId

    override fun areContentsTheSame(
        oldItem: Round,
        newItem: Round
    ) = oldItem == newItem
}

class RoundsListAdapter(private val roundsAdapterListener: RoundsAdapterListener) :
    ListAdapter<Round, RoundsListHolder>(RoundsUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoundsListHolder {
        return RoundsListHolder(
            ItemRoundBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RoundsListHolder, position: Int) {
        holder.bind(getItem(position), object : RoundsAdapterListener {
            override fun onRoundClick(round: Round) {
                roundsAdapterListener.onRoundClick(round)
            }

            override fun onLessThanTen() = Unit

            override fun onTimerFinished() = Unit
        })    }

}