package com.example.greekkino.ui.rounds

import android.os.Build
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.greekkino.R
import com.example.greekkino.data.models.ui.Round
import com.example.greekkino.databinding.ItemRoundBinding
import com.example.greekkino.utils.extensions.convertLongToOffsetDateTime
import com.example.greekkino.utils.extensions.convertLongToTime
import com.example.greekkino.utils.extensions.toRoundTimeLeftFormatted
import java.time.OffsetDateTime

class RoundsListHolder(private val binding: ItemRoundBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var timer: CountDownTimer? = null

    companion object {
        const val COUNTDOWN_INTERVAL = 1000L
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        round: Round,
        listener: RoundsAdapterListener
    ) {
        with(binding) {
            tvTime.text = round.drawTime.convertLongToTime()

            if (round.drawTime.convertLongToOffsetDateTime().isBefore(OffsetDateTime.now())) {
                listener.onTimerFinished()
            } else {
                setUpTimer(round.drawTime.convertLongToOffsetDateTime(), listener)
            }
            root.setOnClickListener {
                listener.onRoundClick(round)
            }
        }
    }

@RequiresApi(Build.VERSION_CODES.O)
private fun setUpTimer(endTime: OffsetDateTime, listener: RoundsAdapterListener) {
    timer?.cancel()
        val nowEpochMilli = OffsetDateTime.now().toInstant().toEpochMilli()
        val untilEndMillis = endTime
            .toInstant()?.toEpochMilli()?.minus(nowEpochMilli) ?: Long.MIN_VALUE

        timer = object : CountDownTimer(untilEndMillis, COUNTDOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                val timeUntilText = millisUntilFinished.toRoundTimeLeftFormatted()
                binding.tvTimer.text = timeUntilText
                if (millisUntilFinished < 60000) {
                    binding.tvTimer.setTextColor(binding.root.context.getColor(R.color.red))
                } else {
                    binding.tvTimer.setTextColor(binding.root.context.getColor(R.color.grey))
                }
            }

            override fun onFinish() {
                listener.onTimerFinished()
                binding.tvTimer.text = "0m :0s"
                binding.tvTimer.setTextColor(binding.root.context.getColor(R.color.red))
            }
        }.start()
    }
}

interface RoundsAdapterListener {
    fun onRoundClick(round: Round)
    fun onLessThanTen()
    fun onTimerFinished()
}