package com.pnvpnvpnv.timetesttask.domain.mappers

import com.pnvpnvpnv.timetesttask.data.models.CityDTO
import com.pnvpnvpnv.timetesttask.domain.models.City
import javax.inject.Inject

class CityMapper @Inject constructor() {
    fun mapLocalToDomain(local: List<CityDTO>): List<City> {
        return local.map {
            City(
                nameRes = it.nameRes,
                timeZoneName = it.timeZoneName
            )
        }
    }
}