package com.pnvpnvpnv.timetesttask.data

import com.pnvpnvpnv.timetesttask.data.models.CityDTO
import com.pnvpnvpnv.timetesttask.data.models.TimeDTO
import com.pnvpnvpnv.timetesttask.data.network.TimeApiClient
import com.pnvpnvpnv.timetesttask.domain.repos.TimeRepository
import javax.inject.Inject

class TimeRepositoryImpl @Inject constructor(
    private val timeApiClient: TimeApiClient,
) : TimeRepository {
    override suspend fun fetchCurrentTime(model: CityDTO): TimeDTO {
        return timeApiClient.fetchCurrentTime(model)
    }
}