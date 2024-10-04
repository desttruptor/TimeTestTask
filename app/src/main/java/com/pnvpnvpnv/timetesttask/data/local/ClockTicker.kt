package com.pnvpnvpnv.timetesttask.data.local

import com.pnvpnvpnv.timetesttask.util.TimeFormatter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClockTicker @Inject constructor(
    private val timeFormatter: TimeFormatter
) {
    private var time = 0L
    private var active = false

    fun getTickerFlow(iHour: Int, iMunute: Int, iSecond: Int) = flow<String> {
        val apiTime = timeFormatter.apiTimeToUnix(iHour, iMunute, iSecond)
        time = apiTime

        active = true
        while (active) {
            val formattedTime = timeFormatter.unixTimeToString(time)
            emit(formattedTime)
            delay(1000)
            time++
        }
    }.flowOn(Dispatchers.Default)


    fun stopTicker() {
        active = false
    }
}