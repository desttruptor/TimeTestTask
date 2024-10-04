package com.pnvpnvpnv.timetesttask.data.repository

import com.pnvpnvpnv.timetesttask.data.local.ClockTicker
import com.pnvpnvpnv.timetesttask.data.network.TimeApiClient
import com.pnvpnvpnv.timetesttask.domain.mappers.TimeMapper
import com.pnvpnvpnv.timetesttask.domain.models.Time
import com.pnvpnvpnv.timetesttask.domain.repository.TimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TimeRepositoryImpl @Inject constructor(
    private val clockTicker: ClockTicker,
    private val timeApiClient: TimeApiClient,
    private val timeMapper: TimeMapper,
) : TimeRepository {
    override suspend fun fetchCurrentTime(timeZone: String): Time {
        val remote = timeApiClient.fetchCurrentTime(timeZone)
        return timeMapper.mapRemoteToDomain(remote)
    }

    override fun getClockTickerFlow(hour: Int, minute: Int, second: Int): Flow<String> {
        return clockTicker.getTickerFlow(hour, minute, second)
    }

    override suspend fun stopTicker() {
        clockTicker.stopTicker()
    }
}
