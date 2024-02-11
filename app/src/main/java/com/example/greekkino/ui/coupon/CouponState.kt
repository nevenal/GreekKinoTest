package com.example.greekkino.ui.coupon

import com.example.greekkino.data.models.ui.Coupon
import com.example.greekkino.data.models.ui.CouponNumber
import com.example.greekkino.ui.base.BaseState

sealed class CouponState : BaseState {
    class CouponLoaded(var coupon: Coupon, var numbersList: List<CouponNumber>) : CouponState()
    class RefreshNumbers(var numbersList: List<CouponNumber>, var numbersCount: Int) : CouponState()
}