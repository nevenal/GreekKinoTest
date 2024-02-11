package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WinningNumbers(
    val list: List<Int>,
    val bonus: List<Int>,
    val sidebets: Sidebets?
) : Parcelable