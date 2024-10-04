package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.models

import androidx.compose.runtime.Stable

data class CityTimeState(
    @Stable
    val cityNameRes: Int?,
    val cityTime: String?,
    @Stable
    val isLoading: Boolean,
)