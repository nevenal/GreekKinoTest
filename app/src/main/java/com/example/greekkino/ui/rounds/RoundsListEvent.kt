package com.example.greekkino.ui.rounds

import com.example.greekkino.ui.base.BaseEvent

sealed class RoundsListEvent : BaseEvent{
    class OnRoundClicked(var drawId: Int) : RoundsListEvent()
}