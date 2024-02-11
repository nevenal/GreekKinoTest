package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sidebets(
    val evenNumbersCount: Int,
    val oddNumbersCount: Int,
    val winningColumn: Int,
    val winningParity: String,
    val oddNumbers: List<Int>,
    val evenNumbers: List<Int>,
    val columnNumbers: ColumnNumbers?
) : Parcelable