package com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time

import com.pnvpnvpnv.timetesttask.R
import com.pnvpnvpnv.timetesttask.domain.error.GenericError
import com.pnvpnvpnv.timetesttask.domain.error.MappingError
import com.pnvpnvpnv.timetesttask.domain.error.NetworkError
import com.pnvpnvpnv.timetesttask.domain.usecases.GetCitiesUseCase
import com.pnvpnvpnv.timetesttask.domain.usecases.GetClockTickerUseCase
import com.pnvpnvpnv.timetesttask.domain.usecases.GetLastCityTimeZoneUseCase
import com.pnvpnvpnv.timetesttask.domain.usecases.GetTimeUseCase
import com.pnvpnvpnv.timetesttask.domain.usecases.SaveLastCityTimeZoneUseCase
import com.pnvpnvpnv.timetesttask.domain.usecases.StopTickerUseCase
import com.pnvpnvpnv.timetesttask.presentation.ui.BaseViewModel
import com.pnvpnvpnv.timetesttask.presentation.ui.screens.city_time.models.CityTimeEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CityTimeViewModel @Inject constructor(
    private val getLastCityTimeZoneUseCase: GetLastCityTimeZoneUseCase,
    private val getCitiesUseCase: GetCitiesUseCase,
    private val saveLastCityTimeZoneUseCase: SaveLastCityTimeZoneUseCase,
    private val getClockTickerUseCase: GetClockTickerUseCase,
    private val getTimeUseCase: GetTimeUseCase,
    private val stopTickerUseCase: StopTickerUseCase,
    private val stateReducer: CityTimeStateReducer,
) : BaseViewModel() {

    private var clockJob: Job? = null
    private val _state = MutableStateFlow(stateReducer.initialState())
    private val _effect = Channel<CityTimeEffect>()

    val state = _state.asStateFlow()
    val effect = _effect.receiveAsFlow()

    init {
        launch {
            errorEffectFlow.collectLatest {
                when (it) {
                    is NetworkError -> _effect.send(CityTimeEffect.ShowError(R.string.network_error_occured))
                    is MappingError -> _effect.send(CityTimeEffect.ShowError(R.string.mapping_error_occured))
                    is GenericError -> _effect.send(CityTimeEffect.ShowError(R.string.unknown_error_occured))
                }
            }
        }
    }

    fun startClock() {
        clockJob?.cancel()
        clockJob = launch {
            stopTickerUseCase.executeOrThrow(Unit)

            _state.update {
                stateReducer.showLoading()
            }

            val timeZone = getLastCityTimeZoneUseCase.execute(Unit).first()
            val cities = getCitiesUseCase.executeOrThrow(Unit)
            val city = timeZone?.let { tz ->
                saveLastCityTimeZoneUseCase.executeOrThrow(tz)

                cities.find {
                    it.timeZoneName == tz
                }
            } ?: cities.firstOrNull() ?: error("Список городов пуст!")

            val time = getTimeUseCase.executeOrThrow(city.timeZoneName)
            val params = GetClockTickerUseCase.Params(
                hour = time.hour,
                minute = time.minute,
                second = time.second,
            )

            getClockTickerUseCase
                .execute(params)
                .collectLatest { actualTime ->
                    _state.update {
                        stateReducer.showTimeAndCity(
                            prevState = it,
                            city = city.nameRes,
                            time = actualTime
                        )
                    }
                }
        }
    }
}