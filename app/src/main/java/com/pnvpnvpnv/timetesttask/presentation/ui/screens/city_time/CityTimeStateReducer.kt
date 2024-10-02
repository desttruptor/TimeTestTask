package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time

import javax.inject.Inject

class CityTimeStateReducer @Inject constructor() {
    fun initialState() = CityTimeState(
        cityName = null,
        currentTime = null,
    )
}