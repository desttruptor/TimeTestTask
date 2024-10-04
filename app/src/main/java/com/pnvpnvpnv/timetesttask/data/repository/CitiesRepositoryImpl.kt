package com.pnvpnvpnv.timetesttask.data.repository

import com.pnvpnvpnv.timetesttask.data.local.CitiesDataSource
import com.pnvpnvpnv.timetesttask.domain.mappers.CityMapper
import com.pnvpnvpnv.timetesttask.domain.models.City
import com.pnvpnvpnv.timetesttask.domain.repository.CitiesRepository
import javax.inject.Inject

class CitiesRepositoryImpl @Inject constructor(
    private val citiesDataSource: CitiesDataSource,
    private val cityMapper: CityMapper
) : CitiesRepository {
    override fun getCities(): List<City> {
        val local = citiesDataSource.getCities()
        return cityMapper.mapLocalToDomain(local)
    }
}