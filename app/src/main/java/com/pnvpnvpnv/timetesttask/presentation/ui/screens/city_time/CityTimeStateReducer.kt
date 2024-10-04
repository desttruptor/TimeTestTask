package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time

import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.models.CityTimeState
import javax.inject.Inject

class CityTimeStateReducer @Inject constructor() {
    fun initialState() = CityTimeState(
        cityNameRes = null,
        cityTime = null,
        isLoading = true
    )

    fun showLoading() = CityTimeState(
        cityNameRes = null,
        cityTime = null,
        isLoading = true
    )

    fun showTimeAndCity(
        prevState: CityTimeState,
        city: Int,
        time: String
    ) = prevState.copy(
        cityNameRes = city,
        cityTime = time,
        isLoading = false
    )
}