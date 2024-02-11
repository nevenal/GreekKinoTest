package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.math.BigInteger

@Parcelize
data class Round(
    val gameId: Int,
    val drawId: Int,
    val drawTime: Long,
    val status: String,
    val drawBreak: Int,
    val visualDraw: Int,
    val pricePoints: PricePoint?,
    val prizeCategories: List<PrizeCategory>,
    val wagerStatistics: WagerStatistics?
) : Parcelable