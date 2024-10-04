package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list

import com.pnvpnvpnv.timetesttask.domain.models.City
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list.models.CityListState
import javax.inject.Inject

class CityListStateReducer @Inject constructor() {
    fun initialState() = CityListState(
        cityList = emptyList(),
        isLoading = true
    )

    fun showCitiesList(
        prevState: CityListState,
        list: List<City>
    ) = prevState.copy(cityList = list, isLoading = false)
}