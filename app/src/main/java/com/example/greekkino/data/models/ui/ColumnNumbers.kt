package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColumnNumbers(
    val one: List<Int>,
    val two: List<Int>,
    val three: List<Int>,
    val four: List<Int>,
    val five: List<Int>,
    val six: List<Int>,
    val seven: List<Int>,
    val eight: List<Int>,
    val nine: List<Int>,
    val ten: List<Int>
) : Parcelable