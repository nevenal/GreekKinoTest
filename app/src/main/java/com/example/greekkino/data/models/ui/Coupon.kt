package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coupon(
    val gameId: Int,
    val drawId: Int,
    val drawTime: Long?,
    val status: String,
    val drawBreak: Int,
    val visualDraw: Int,
    val pricePoints: PricePoint?,
    val winningNumbers: WinningNumbers?,
    val prizeCategories: List<PrizeCategory>,
    val wagerStatistics: WagerStatistics?
) : Parcelable