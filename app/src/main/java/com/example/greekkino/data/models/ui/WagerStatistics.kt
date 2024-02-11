package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class WagerStatistics (
    val columns: Int,
    val wagers: Int,
    val addOn: List<AddOn>
): Parcelable