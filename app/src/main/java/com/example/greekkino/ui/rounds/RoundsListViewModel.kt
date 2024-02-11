package com.example.greekkino.ui.rounds

import androidx.lifecycle.viewModelScope
import com.example.greekkino.data.usecases.GetRoundsUseCase
import com.example.greekkino.ui.base.BaseViewModel
import com.example.greekkino.utils.extensions.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val GAME_ID = 1100

@HiltViewModel
class RoundsListViewModel @Inject constructor(
    private val getRoundsUseCase: GetRoundsUseCase
) : BaseViewModel<RoundsListState, RoundsListEvent, RoundsListAction>() {

    override fun executeAction(action: RoundsListAction) {
        super.executeAction(action)
        when (action) {
            is RoundsListAction.LoadRounds -> {
                viewModelScope.launchWithErrorHandling {
                    val roundsList = getRoundsUseCase.execute(GAME_ID)
                    if (roundsList.isNotEmpty()) {
                        state.postValue(RoundsListState.RoundsLoaded(roundsList))
                    }
                }

            }

            is RoundsListAction.ClickOnRound -> {
                event.postEvent(RoundsListEvent.OnRoundClicked(action.round.drawId))
            }
        }
    }
}