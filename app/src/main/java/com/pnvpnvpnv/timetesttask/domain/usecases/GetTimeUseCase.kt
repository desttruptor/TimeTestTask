package com.pnvpnvpnv.timetesttask.domain.usecases

import com.pnvpnvpnv.timetesttask.domain.BaseUseCase
import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import com.pnvpnvpnv.timetesttask.domain.models.Time
import com.pnvpnvpnv.timetesttask.domain.repository.TimeRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetTimeUseCase @Inject constructor(
    errorConverter: ErrorConverter,
    private val timeRepository: TimeRepository,
) : BaseUseCase<String, Time>(
    executionContext = Dispatchers.IO,
    errorConverter = errorConverter
) {
    override suspend fun executeOnBackground(params: String): Time {
        return timeRepository.fetchCurrentTime(params)
    }
}