package com.pnvpnvpnv.timetesttask.data.local

import com.pnvpnvpnv.timetesttask.util.TimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Clock @Inject constructor(
    private val formatter: TimeFormatter
) {
    private var currentTime: Long = 0L

    fun tickSecond() {
        currentTime++
    }

    fun getFormattedTime(): String {
        return formatter.unixTimeToString(currentTime)
    }

    fun setApiTime(hour: Int, minute: Int, second: Int) {
        currentTime = formatter.apiTimeToUnix(hour, minute, second)
    }
}