package com.example.greekkino.ui.rounds

import com.example.greekkino.data.models.ui.Round
import com.example.greekkino.ui.base.BaseAction

sealed class RoundsListAction : BaseAction {
    object LoadRounds : RoundsListAction()
    class ClickOnRound (var round: Round) : RoundsListAction()
}