package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PricePoint(
    val addOn: List<AddOn>?,
    val amount: Double
): Parcelable