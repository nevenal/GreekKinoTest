package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.Coupon
import com.google.gson.annotations.SerializedName

data class CouponDTO(
    @SerializedName("gameId") val gameId: Int?,
    @SerializedName("drawId") val drawId: Int?,
    @SerializedName("drawTime") val drawTime: Long?,
    @SerializedName("status") val status: String?,
    @SerializedName("drawBreak") val drawBreak: Int?,
    @SerializedName("visualDraw") val visualDraw: Int?,
    @SerializedName("pricePoints") val pricePoints: PricePointDTO?,
    @SerializedName("winningNumbers") val winningNumbers: WinningNumbersDTO?,
    @SerializedName("prizeCategories") val prizeCategories: List<PrizeCategoryDTO>?,
    @SerializedName("wagerStatistics") val wagerStatistics: WagerStatisticsDTO?

) {
    fun mapToUI() = Coupon(
        gameId = this.gameId ?: -1,
        drawId = this.drawId ?: -1,
        drawTime = this.drawTime,
        status = this.status.orEmpty(),
        drawBreak = this.drawBreak ?: -1,
        visualDraw = this.visualDraw ?: -1,
        pricePoints = this.pricePoints?.mapToUI(),
        winningNumbers = this.winningNumbers?.mapToUi(),
        prizeCategories = this.prizeCategories?.map { it.mapToUI() }.orEmpty(),
        wagerStatistics = this.wagerStatistics?.mapToUi()
    )
}