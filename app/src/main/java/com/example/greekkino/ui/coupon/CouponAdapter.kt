package com.example.greekkino.ui.coupon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.greekkino.data.models.ui.CouponNumber
import com.example.greekkino.databinding.ItemNumberBinding

object CouponUtils : DiffUtil.ItemCallback<CouponNumber>() {

    override fun areItemsTheSame(
        oldItem: CouponNumber,
        newItem: CouponNumber
    ) = oldItem.value == newItem.value

    override fun areContentsTheSame(
        oldItem: CouponNumber,
        newItem: CouponNumber
    ) = oldItem == newItem
}

class CouponAdapter(private val couponNumbersListener: CouponNumbersListener) :
    ListAdapter<CouponNumber, CouponHolder>(CouponUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponHolder {
        return CouponHolder(
            ItemNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CouponHolder, position: Int) {
        holder.bind(getItem(position), object : CouponNumbersListener {
            override fun onNumberClick(number: CouponNumber) {
                couponNumbersListener.onNumberClick(number)
            }
        })
    }

}