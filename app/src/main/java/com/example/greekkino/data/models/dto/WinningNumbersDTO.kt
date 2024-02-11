package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.WinningNumbers
import com.google.gson.annotations.SerializedName

data class WinningNumbersDTO(
    @SerializedName("list") val list: List<Int>?,
    @SerializedName("bonus") val bonus: List<Int>?,
    @SerializedName("sidebets") val sidebets: SidebetsDTO?
) {
    fun mapToUi() = WinningNumbers(
        list = this.list.orEmpty(),
        bonus = this.bonus.orEmpty(),
        sidebets = this.sidebets?.mapToUi()
    )
}