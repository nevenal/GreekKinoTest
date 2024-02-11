package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PrizeCategory (
    val id: Int,
    val divident: Int,
    val winners: Int,
    val distributed: Int,
    val jackpot: Int,
    val fixed: Double,
    val categoryType: Int,
    val gameType: String
): Parcelable