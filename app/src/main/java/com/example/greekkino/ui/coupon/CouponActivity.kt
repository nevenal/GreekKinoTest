package com.example.greekkino.ui.coupon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.greekkino.data.models.ui.Coupon
import com.example.greekkino.data.models.ui.CouponNumber
import com.example.greekkino.data.models.ui.Round
import com.example.greekkino.databinding.ActivityCouponBinding
import com.example.greekkino.ui.base.BaseActivity
import com.example.greekkino.ui.rounds.RoundsAdapterListener
import com.example.greekkino.ui.rounds.RoundsListAction
import com.example.greekkino.ui.rounds.RoundsListAdapter
import com.example.greekkino.ui.webview.WebViewAnimationActivity
import com.example.greekkino.utils.extensions.convertLongToTime
import com.example.greekkino.utils.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CouponActivity :
    BaseActivity<ActivityCouponBinding, CouponState, CouponEvent, CouponAction>() {

    companion object {
        private const val EXTRA_DRAW_ID = "drawId"

        @JvmStatic
        fun newIntent(
            context: Context,
            drawId: Int
        ) = Intent(context, CouponActivity::class.java).apply {
            putExtras(Bundle().apply {
                putInt(EXTRA_DRAW_ID, drawId)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        val drawId = extras?.getInt(EXTRA_DRAW_ID, -1)
        drawId?.let {
            init(it)
        }
    }

    private fun init(drawId: Int) {
        binding.rvNumbers.adapter = couponAdapter
        viewModel.executeAction(CouponAction.Init(drawId))
    }

    private fun initUi(coupon: Coupon, numbersList: List<CouponNumber>) {
        with(binding) {
            tvRoundTimeValue.text = coupon.drawTime?.convertLongToTime()
            tvRoundValue.text = coupon.visualDraw.toString()
            couponAdapter.submitList(numbersList)

            tvRandomChoice.setOnClickListener { viewModel.executeAction(CouponAction.RandomChoice) }
        }
    }

    override fun doBinding() = viewBinding(ActivityCouponBinding::inflate)

    private val viewModel: CouponViewModel by viewModels()

    override fun provideViewModel() = viewModel

    override fun onEvent(event: CouponEvent) {
        when (event) {
            is CouponEvent.RandomChoice -> {
                startActivity(Intent(this, WebViewAnimationActivity::class.java))
            }
        }
    }

    override fun render(state: CouponState) {
        when (state) {
            is CouponState.CouponLoaded -> {
                initUi(state.coupon, state.numbersList)
            }

            is CouponState.RefreshNumbers -> {
                couponAdapter.submitList(state.numbersList)
                binding.tvNumbersValue.text = state.numbersCount.toString()
            }
        }
    }

    private val couponAdapter = CouponAdapter(object : CouponNumbersListener {
        override fun onNumberClick(number: CouponNumber) {
            viewModel.executeAction(
                CouponAction.OnNumberClicked(number)
            )
        }
    })
}