package com.example.greekkino.data.models.dto

import com.example.greekkino.data.models.ui.WagerStatistics
import com.google.gson.annotations.SerializedName

data class WagerStatisticsDTO(
    @SerializedName("columns") val columns: Int?,
    @SerializedName("wagers") val wagers: Int?,
    @SerializedName("addOn") val addOn: List<AddOnDTO>?
) {
    fun mapToUi() = WagerStatistics(
        columns = this.columns ?: -1,
        wagers = this.wagers ?: -1,
        addOn = this.addOn?.map { it.mapToUI() }.orEmpty()
    )
}