package com.example.greekkino.data.usecases

import com.example.greekkino.data.models.ApiService
import com.example.greekkino.data.models.ui.Coupon
import timber.log.Timber
import javax.inject.Inject

class GetCouponUseCase @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun execute(gameId: Int, drawId: Int): Coupon? {
        return try {
            apiService.getCoupon(gameId, drawId).mapToUI()
        } catch (exception: Throwable) {
            Timber.e(exception)
            null
        }
    }
}