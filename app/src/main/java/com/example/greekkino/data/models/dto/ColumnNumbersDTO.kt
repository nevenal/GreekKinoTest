package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.ColumnNumbers
import com.google.gson.annotations.SerializedName

data class ColumnNumbersDTO(
    @SerializedName("1") val one: List<Int>?,
    @SerializedName("2") val two: List<Int>?,
    @SerializedName("3") val three: List<Int>?,
    @SerializedName("4") val four: List<Int>?,
    @SerializedName("5") val five: List<Int>?,
    @SerializedName("6") val six: List<Int>?,
    @SerializedName("7") val seven: List<Int>?,
    @SerializedName("8") val eight: List<Int>?,
    @SerializedName("9") val nine: List<Int>?,
    @SerializedName("10") val ten: List<Int>?,
) {
    fun mapToUi() = ColumnNumbers(
        one = this.one.orEmpty(),
        two = this.two.orEmpty(),
        three = this.three.orEmpty(),
        four = this.four.orEmpty(),
        five = this.five.orEmpty(),
        six = this.six.orEmpty(),
        seven = this.seven.orEmpty(),
        eight = this.eight.orEmpty(),
        nine = this.nine.orEmpty(),
        ten = this.ten.orEmpty()
    )
}