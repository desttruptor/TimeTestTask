package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CityTimeViewModel @Inject constructor(
    private val stateReducer: CityTimeStateReducer,
) : ViewModel() {
    private val timeUpdateJob: Job? = null
    private val _state = MutableStateFlow(stateReducer.initialState())

    val state = _state.asStateFlow()

    fun postEvent(event: CityTimeEvent) = when (event) {
        is CityTimeEvent.ChangeCity -> navigateToCityList()
    }

    private fun navigateToCityList() {

    }
}