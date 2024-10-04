package com.pnvpnvpnv.timetesttask.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.pnvpnvpnv.timetesttask.domain.repository.CityPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeZonePreferencesRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : CityPreferencesRepository {
    override val lastCityTimeZone: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[LAST_CITY_TIMEZONE_KEY]
        }

    override suspend fun saveLastCityTimeZone(timeZone: String) {
        dataStore.edit { preferences ->
            preferences[LAST_CITY_TIMEZONE_KEY] = timeZone
        }
    }

    companion object {
        val LAST_CITY_TIMEZONE_KEY = stringPreferencesKey("last_city_timezone")
    }
}