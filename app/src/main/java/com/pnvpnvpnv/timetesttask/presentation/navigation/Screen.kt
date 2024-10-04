package com.pnvpnvpnv.timetesttask.presentation.navigation

sealed class Screen(val route: String) {
    data object CityTime : Screen("city_time")
    data object CityList : Screen("city_list")
}