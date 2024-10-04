package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list.models

import com.pnvpnvpnv.timetesttask.domain.models.City

data class CityListState(
    val cityList: List<City>,
    val isLoading: Boolean,
)