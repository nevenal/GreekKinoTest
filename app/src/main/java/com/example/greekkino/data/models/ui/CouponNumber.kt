package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CouponNumber (
    val value: Int,
    var chosen: Boolean = false
) : Parcelable