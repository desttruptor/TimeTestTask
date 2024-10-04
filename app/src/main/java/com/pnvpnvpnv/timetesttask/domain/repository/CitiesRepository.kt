package com.pnvpnvpnv.timetesttask.domain.repository

import com.pnvpnvpnv.timetesttask.domain.models.City

interface CitiesRepository {
    fun getCities(): List<City>
}