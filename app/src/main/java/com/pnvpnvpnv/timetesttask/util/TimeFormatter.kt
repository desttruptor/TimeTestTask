package com.pnvpnvpnv.timetesttask.util

import javax.inject.Inject

class TimeFormatter @Inject constructor() {
    fun unixTimeToString(unix: Long): String {
        val hours = unix / 3600
        val minutes = (unix % 3600) / 60
        val seconds = unix % 60
        val sb = StringBuilder(8) // "HH:MM:SS" lenght is 8

        if (hours < 10) sb.append('0')
        sb.append(hours).append(':')

        if (minutes < 10) sb.append('0')
        sb.append(minutes).append(':')

        if (seconds < 10) sb.append('0')
        sb.append(seconds)

        return sb.toString()
    }

    fun apiTimeToUnix(hour: Int, minute: Int, second: Int): Long {
        return (hour * 3600L) + (minute * 60L) + second
    }
}