package com.pnvpnvpnv.timetesttask.di

import com.pnvpnvpnv.timetesttask.data.repository.TimeRepositoryImpl
import com.pnvpnvpnv.timetesttask.domain.repository.TimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkBindings {
    @Binds
    abstract fun bindTimeRepository(impl: TimeRepositoryImpl): TimeRepository
}