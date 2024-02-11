package com.example.greekkino.utils.extensions

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.greekkino.GreekKinoConstants.SIXTY
import com.example.greekkino.GreekKinoConstants.THOUSAND
import com.example.greekkino.GreekKinoConstants.TWENTY_FOUR
import com.example.greekkino.GreekKinoConstants.ZERO
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.Date
import java.util.Locale

fun Long.toRoundTimeLeftFormatted(): String {
    val seconds = this / THOUSAND
    val minutes = seconds / SIXTY
    val hours = minutes / SIXTY
    val days = hours / TWENTY_FOUR
    val secondsToDisplay = seconds - minutes * SIXTY
    val minutesToDisplay = minutes - hours * SIXTY
    val hoursToDisplay = hours - days * TWENTY_FOUR
    val builder = StringBuilder()

    if (hours > ZERO) {
        builder.append(hoursToDisplay).append("h : ")
    }
    if (minutes > ZERO) {
        builder.append(minutesToDisplay).append("m : ")
    }
    builder.append(secondsToDisplay).append("s")
    return builder.toString()
}

fun Long.convertLongToTime(): String {
    val date = Date(this)
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    return format.format(date)
}


@RequiresApi(Build.VERSION_CODES.O)
fun Long.convertLongToOffsetDateTime(): OffsetDateTime {
    return OffsetDateTime.of(LocalDateTime.ofEpochSecond(this/ THOUSAND, 0, ZoneOffset.UTC), ZoneOffset.UTC)
}