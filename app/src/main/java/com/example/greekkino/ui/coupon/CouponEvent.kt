package com.example.greekkino.ui.coupon

import com.example.greekkino.ui.base.BaseEvent

sealed class CouponEvent : BaseEvent {
    object RandomChoice : CouponEvent()
}