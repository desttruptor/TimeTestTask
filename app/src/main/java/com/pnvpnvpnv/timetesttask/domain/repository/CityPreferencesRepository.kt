package com.pnvpnvpnv.timetesttask.domain.repository

import kotlinx.coroutines.flow.Flow

interface CityPreferencesRepository {
    val lastCityTimeZone: Flow<String?>
    suspend fun saveLastCityTimeZone(timeZone: String)
}