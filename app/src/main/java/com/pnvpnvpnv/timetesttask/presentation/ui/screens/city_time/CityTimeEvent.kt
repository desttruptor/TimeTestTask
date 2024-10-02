package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time

sealed interface CityTimeEvent {
    data object ChangeCity : CityTimeEvent
}