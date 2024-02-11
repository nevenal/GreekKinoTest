package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.Sidebets
import com.google.gson.annotations.SerializedName

data class SidebetsDTO(
    @SerializedName("evenNumbersCount") val evenNumbersCount: Int?,
    @SerializedName("oddNumbersCount") val oddNumbersCount: Int?,
    @SerializedName("winningColumn") val winningColumn: Int?,
    @SerializedName("winningParity") val winningParity: String?,
    @SerializedName("oddNumbers") val oddNumbers: List<Int>?,
    @SerializedName("evenNumbers") val evenNumbers: List<Int>?,
    @SerializedName("columnNumbers") val columnNumbers: ColumnNumbersDTO?

) {
    fun mapToUi() = Sidebets(
        evenNumbersCount = this.evenNumbersCount ?: -1,
        oddNumbersCount = this.oddNumbersCount ?: -1,
        winningColumn = this.winningColumn ?: -1,
        winningParity = this.winningParity.orEmpty(),
        oddNumbers = this.oddNumbers.orEmpty(),
        evenNumbers = this.evenNumbers.orEmpty(),
        columnNumbers = this.columnNumbers?.mapToUi()

    )
}