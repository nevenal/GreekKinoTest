package com.example.greekkino.data.usecases

import com.example.greekkino.data.models.ApiService
import com.example.greekkino.data.models.ui.Round
import timber.log.Timber
import javax.inject.Inject

class GetRoundsUseCase @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun execute(gameId: Int): List<Round> {
        return try {
            apiService.getRounds(gameId).map { it.mapToUI() }
        } catch (exception: Throwable) {
            Timber.e(exception)
            emptyList()
        }
    }
}