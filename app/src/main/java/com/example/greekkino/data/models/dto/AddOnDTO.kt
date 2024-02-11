package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.AddOn
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class AddOnDTO(
    @SerializedName("amount") val amount: BigDecimal?,
    @SerializedName("gameType") val gameType: String?
) {
    fun mapToUI() = AddOn(
        amount = this.amount ?: BigDecimal.ZERO,
        gameType = this.gameType.orEmpty()
    )
}