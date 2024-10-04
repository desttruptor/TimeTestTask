package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.models

sealed interface CityTimeEffect {
    data class ShowError(val errorTextRes: Int) : CityTimeEffect
}