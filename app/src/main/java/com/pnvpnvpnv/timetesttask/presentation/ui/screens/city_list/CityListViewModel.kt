package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_list

import androidx.navigation.NavController
import com.pnvpnvpnv.timetesttask.domain.models.City
import com.pnvpnvpnv.timetesttask.domain.usecases.GetCitiesUseCase
import com.pnvpnvpnv.timetesttask.domain.usecases.SaveLastCityTimeZoneUseCase
import com.pnvpnvpnv.timetesttask.presentation.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val saveLastCityTimeZoneUseCase: SaveLastCityTimeZoneUseCase,
    private val getCitiesUseCase: GetCitiesUseCase,
    private val stateReducer: CityListStateReducer,
) : BaseViewModel() {

    private val _state = MutableStateFlow(stateReducer.initialState())

    val state = _state.asStateFlow()

    init {
        launch {
            val cities = getCitiesUseCase.executeOrThrow(Unit)
            _state.update {
                stateReducer.showCitiesList(
                    prevState = it,
                    list = cities
                )
            }
        }
    }

    fun onCitySelected(city: City, navController: NavController) {
        launch {
            saveLastCityTimeZoneUseCase.executeOrThrow(city.timeZoneName)
            navController.popBackStack()
        }
    }
}