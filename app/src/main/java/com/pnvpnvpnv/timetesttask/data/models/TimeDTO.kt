package com.pnvpnvpnv.timetesttask.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimeDTO(
    @SerialName("dateTime") val dateTime: String? = null,
    @SerialName("date") val date: String? = null,
    @SerialName("dstActive") val dstActive: Boolean? = null,
    @SerialName("year") val year: Int? = null,
    @SerialName("timeZone") val timeZone: String? = null,
    @SerialName("minute") val minute: Int? = null,
    @SerialName("seconds") val seconds: Int? = null,
    @SerialName("dayOfWeek") val dayOfWeek: String? = null,
    @SerialName("month") val month: Int? = null,
    @SerialName("hour") val hour: Int? = null,
    @SerialName("time") val time: String? = null,
    @SerialName("day") val day: Int? = null,
    @SerialName("milliSeconds") val milliSeconds: Int? = null
)
