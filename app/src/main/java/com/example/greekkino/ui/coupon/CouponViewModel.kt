package com.example.greekkino.ui.coupon


import androidx.lifecycle.viewModelScope
import com.example.greekkino.data.models.ui.CouponNumber
import com.example.greekkino.data.usecases.GetCouponUseCase
import com.example.greekkino.ui.base.BaseViewModel
import com.example.greekkino.utils.extensions.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val GAME_ID = 1100

@HiltViewModel
class CouponViewModel @Inject constructor(
    private var getCouponUseCase: GetCouponUseCase
) : BaseViewModel<CouponState, CouponEvent, CouponAction>() {

    private var numbersList: MutableList<CouponNumber>? = null
    private var numbersChosen: Int = 0

    override fun executeAction(action: CouponAction) {
        super.executeAction(action)
        when (action) {
            is CouponAction.Init -> {
                numbersList = ArrayList()
                for (i in 1..80) {
                    val couponNumber = CouponNumber(i, false)
                    numbersList?.add(i - 1, couponNumber)
                }
                viewModelScope.launchWithErrorHandling {
                    val coupon = getCouponUseCase.execute(GAME_ID, action.drawId)
                    coupon?.let { couponLoaded ->
                        numbersList?.let { numbersList ->
                            state.postValue(CouponState.CouponLoaded(couponLoaded, numbersList))
                        }
                    }
                }
            }

            is CouponAction.OnNumberClicked -> {
                if ((!action.number.chosen && numbersChosen < 15) || (action.number.chosen && numbersChosen > 0)) {
                    if (action.number.chosen) {
                        numbersChosen--
                    } else {
                        numbersChosen++
                    }
                    val newList = numbersList?.toMutableList()
                    newList?.forEachIndexed { index, number ->
                        if (number.value == action.number.value) {
                            newList[index] = newList[index].copy().apply { chosen = !number.chosen }
                        }
                    }
                    numbersList = newList
                    numbersList?.let {
                        state.postValue(
                            CouponState.RefreshNumbers(it, numbersChosen)
                        )
                    }
                }
            }

            CouponAction.RandomChoice -> {
                event.postEvent(CouponEvent.RandomChoice)
            }
        }
    }
}