package com.pnvpnvpnv.timetesttask.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _errorEffect: Channel<Throwable> = Channel(
        capacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val errorEffectFlow = _errorEffect.receiveAsFlow()

    protected fun launch(
        errorHandle: (Throwable) -> Unit = { handleError(it) },
        lambda: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch {
        try {
            // Wrapping with coroutineScope to avoid uncaught exceptions from nested coroutines
            coroutineScope {
                lambda(this)
            }
        } catch (t: Throwable) {
            errorHandle(t)
        }
    }


    private fun handleError(it: Throwable) {
        viewModelScope.launch {
            _errorEffect.send(it)
        }
    }
}