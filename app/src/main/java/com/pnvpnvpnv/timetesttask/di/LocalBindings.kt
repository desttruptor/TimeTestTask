package com.pnvpnvpnv.timetesttask.di

import com.pnvpnvpnv.timetesttask.data.repository.CitiesRepositoryImpl
import com.pnvpnvpnv.timetesttask.data.repository.TimeZonePreferencesRepositoryImpl
import com.pnvpnvpnv.timetesttask.domain.repository.CitiesRepository
import com.pnvpnvpnv.timetesttask.domain.repository.CityPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalBindings {
    @Binds
    abstract fun bindCitiesRepository(impl: CitiesRepositoryImpl): CitiesRepository

    @Binds
    abstract fun bindCityPrefsRepository(impl: TimeZonePreferencesRepositoryImpl): CityPreferencesRepository
}