package com.pnvpnvpnv.timetesttask.domain.usecases

import com.pnvpnvpnv.timetesttask.domain.BaseFlowUseCase
import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import com.pnvpnvpnv.timetesttask.domain.repository.CityPreferencesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastCityTimeZoneUseCase @Inject constructor(
    errorConverter: ErrorConverter,
    private val repository: CityPreferencesRepository
) : BaseFlowUseCase<Unit, String?>(
    executionContext = Dispatchers.IO,
    errorMapper = errorConverter
) {
    override fun createFlow(params: Unit): Flow<String?> {
        return repository.lastCityTimeZone
    }
}