package com.pnvpnvpnv.timetesttask.domain.usecases

import com.pnvpnvpnv.timetesttask.domain.BaseUseCase
import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import com.pnvpnvpnv.timetesttask.domain.repository.TimeRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class StopTickerUseCase @Inject constructor(
    errorConverter: ErrorConverter,
    private val timeRepository: TimeRepository,
) : BaseUseCase<Unit, Unit>(
    executionContext = Dispatchers.Default,
    errorConverter = errorConverter
) {
    override suspend fun executeOnBackground(params: Unit) {
        timeRepository.stopTicker()
    }
}