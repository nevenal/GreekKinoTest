package com.example.greekkino.ui.coupon

import com.example.greekkino.data.models.ui.CouponNumber
import com.example.greekkino.ui.base.BaseAction

sealed class CouponAction : BaseAction {
    object RandomChoice : CouponAction()

    class Init(var drawId : Int) : CouponAction()
    class OnNumberClicked (var number: CouponNumber) : CouponAction()
}