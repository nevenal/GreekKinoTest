package com.example.greekkino.ui.rounds

import android.content.Intent
import androidx.activity.viewModels
import com.example.greekkino.data.models.ui.Round
import com.example.greekkino.databinding.ActivityRoundsListBinding
import com.example.greekkino.ui.base.BaseActivity
import com.example.greekkino.ui.coupon.CouponActivity
import com.example.greekkino.ui.webview.WebViewAnimationActivity
import com.example.greekkino.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoundsListActivity :
    BaseActivity<ActivityRoundsListBinding, RoundsListState, RoundsListEvent, RoundsListAction>() {

    override fun doBinding() = viewBinding(ActivityRoundsListBinding::inflate)

    private val viewModel: RoundsListViewModel by viewModels()

    override fun provideViewModel() = viewModel

    override fun onEvent(event: RoundsListEvent) {
        when (event) {
            is RoundsListEvent.OnRoundClicked -> {
                startActivity(
                    CouponActivity.newIntent(
                        this,
                        event.drawId
                    )
                )
            }
        }
    }

    override fun render(state: RoundsListState) {
        when (state) {
            is RoundsListState.RoundsLoaded -> {
                initUi(state.rounds)
            }
        }
    }

    private fun init() {
        viewModel.executeAction(RoundsListAction.LoadRounds)
    }

    private fun initUi(rounds: List<Round>) {
        with(binding) {
            rvRounds.adapter = roundsListAdapter
            roundsListAdapter.submitList(rounds)
        }
    }

    private val roundsListAdapter = RoundsListAdapter(object : RoundsAdapterListener {
        override fun onRoundClick(round: Round) {
            viewModel.executeAction(
                RoundsListAction.ClickOnRound(round)
            )
        }

        override fun onLessThanTen() = Unit

        override fun onTimerFinished() = Unit
    })

    override fun onResume() {
        super.onResume()
        init()
    }
}