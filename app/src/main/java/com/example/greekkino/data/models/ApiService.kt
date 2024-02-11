package com.example.greekkino.data.models

import com.example.greekkino.data.models.dto.CouponDTO
import com.example.greekkino.data.models.dto.RoundDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/draws/v3.0/{gameId}/upcoming/20")
    suspend fun getRounds(
        @Path("gameId") gameId: Int
    ): List<RoundDTO>

    @GET("/draws/v3.0/{gameId}/{drawId}")
    suspend fun getCoupon(
        @Path("gameId") gameId: Int,
        @Path("drawId") drawId: Int
    ): CouponDTO
}