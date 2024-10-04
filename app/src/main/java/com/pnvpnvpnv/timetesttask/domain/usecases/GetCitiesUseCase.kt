package com.pnvpnvpnv.timetesttask.domain.usecases

import com.pnvpnvpnv.timetesttask.domain.BaseUseCase
import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import com.pnvpnvpnv.timetesttask.domain.models.City
import com.pnvpnvpnv.timetesttask.domain.repository.CitiesRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(
    errorConverter: ErrorConverter,
    private val citiesRepository: CitiesRepository
) : BaseUseCase<Unit, List<City>>(
    executionContext = Dispatchers.IO,
    errorConverter = errorConverter,
) {
    override suspend fun executeOnBackground(params: Unit): List<City> {
        return citiesRepository.getCities()
    }
}