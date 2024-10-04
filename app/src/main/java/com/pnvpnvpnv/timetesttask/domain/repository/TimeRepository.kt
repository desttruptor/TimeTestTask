package com.pnvpnvpnv.timetesttask.domain.repository

import com.pnvpnvpnv.timetesttask.domain.models.Time
import kotlinx.coroutines.flow.Flow

interface TimeRepository {
    suspend fun fetchCurrentTime(timeZone: String): Time
    fun getClockTickerFlow(hour: Int, minute: Int, second: Int): Flow<String>
    suspend fun stopTicker()
}