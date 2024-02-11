package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.Round
import com.google.gson.annotations.SerializedName

data class RoundDTO(
    @SerializedName("gameId") val gameId: Int?,
    @SerializedName("drawId") val drawId: Int?,
    @SerializedName("drawTime") val drawTime: Long?,
    @SerializedName("status") val status: String?,
    @SerializedName("drawBreak") val drawBreak: Int?,
    @SerializedName("visualDraw") val visualDraw: Int?,
    @SerializedName("pricePoints") val pricePoints: PricePointDTO?,
    @SerializedName("prizeCategories") val prizeCategories: List<PrizeCategoryDTO>?,
    @SerializedName("wagerStatistics") val wagerStatistics: WagerStatisticsDTO?

) {
    fun mapToUI() = Round(
        gameId = this.gameId ?: -1,
        drawId = this.drawId ?: -1,
        drawTime = this.drawTime ?: -1,
        status = this.status.orEmpty(),
        drawBreak = this.drawBreak ?: -1,
        visualDraw = this.visualDraw ?: -1,
        pricePoints = this.pricePoints?.mapToUI(),
        prizeCategories = this.prizeCategories?.map { it.mapToUI() }.orEmpty(),
        wagerStatistics = this.wagerStatistics?.mapToUi()

    )
}