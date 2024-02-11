package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.PricePoint
import com.google.gson.annotations.SerializedName

data class PricePointDTO (
    @SerializedName("addOn") val addOn: List<AddOnDTO>?,
    @SerializedName("amount") val amount: Double?
) {
    fun mapToUI() = PricePoint(
        addOn = this.addOn?.map { it.mapToUI() },
        amount = this.amount ?: Double.MIN_VALUE
    )
}