package com.pnvpnvpnv.timetesttask.domain.repos

import com.pnvpnvpnv.timetesttask.data.models.CityDTO
import com.pnvpnvpnv.timetesttask.data.models.TimeDTO

interface TimeRepository {
    suspend fun fetchCurrentTime(model: CityDTO): TimeDTO
}