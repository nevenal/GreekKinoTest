package com.example.greekkino.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
class AddOn (
    val amount: BigDecimal,
    val gameType: String
) : Parcelable