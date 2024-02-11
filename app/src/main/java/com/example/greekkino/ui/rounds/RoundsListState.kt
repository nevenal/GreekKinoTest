package com.example.greekkino.ui.rounds

import com.example.greekkino.data.models.ui.Round
import com.example.greekkino.ui.base.BaseState

sealed class RoundsListState : BaseState {
    class RoundsLoaded (val rounds: List<Round>) : RoundsListState()
}