package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.PrizeCategory
import com.google.gson.annotations.SerializedName

data class PrizeCategoryDTO (
    @SerializedName("id") val id: Int?,
    @SerializedName("divident") val divident: Int?,
    @SerializedName("winners") val winners: Int?,
    @SerializedName("distributed") val distributed: Int?,
    @SerializedName("jackpot") val jackpot: Int?,
    @SerializedName("fixed") val fixed: Double?,
    @SerializedName("categoryType") val categoryType: Int?,
    @SerializedName("gameType") val gameType: String?

    ) {
    fun mapToUI() = PrizeCategory(
        id = this.id ?: -1,
        divident = this.divident ?: -1,
        winners = this.winners ?: -1,
        distributed = this.distributed ?: -1,
        jackpot = this.jackpot ?: -1,
        fixed = this.fixed ?: Double.MIN_VALUE,
        categoryType = this.categoryType ?: -1,
        gameType = this.gameType.orEmpty()
    )
}