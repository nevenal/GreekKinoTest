package com.example.greekkino.ui.coupon

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.greekkino.R
import com.example.greekkino.data.models.ui.CouponNumber
import com.example.greekkino.databinding.ItemNumberBinding

class CouponHolder(private val binding: ItemNumberBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        number: CouponNumber,
        listener: CouponNumbersListener
    ) {
        with(binding) {
            tvNumber.text = number.value.toString()
            if (number.chosen) {
                tvNumber.background =
                    ContextCompat.getDrawable(binding.root.context, R.drawable.circle_border_shape)
            } else {
                tvNumber.background = null
            }
            root.setOnClickListener {
                listener.onNumberClick(number)
            }
        }
    }
}

interface CouponNumbersListener {
    fun onNumberClick(number: CouponNumber)
}