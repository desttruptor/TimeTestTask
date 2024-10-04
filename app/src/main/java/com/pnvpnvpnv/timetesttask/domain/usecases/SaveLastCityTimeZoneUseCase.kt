package com.pnvpnvpnv.timetesttask.domain.usecases

import com.pnvpnvpnv.timetesttask.domain.BaseUseCase
import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import com.pnvpnvpnv.timetesttask.domain.repository.CityPreferencesRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class SaveLastCityTimeZoneUseCase @Inject constructor(
    errorConverter: ErrorConverter,
    private val repository: CityPreferencesRepository
) : BaseUseCase<String, Unit>(
    executionContext = Dispatchers.IO,
    errorConverter = errorConverter,
) {
    override suspend fun executeOnBackground(params: String) {
        repository.saveLastCityTimeZone(params)
    }
}
