package com.pnvpnvpnv.timetesttask.domain.mappers

import com.pnvpnvpnv.timetesttask.data.models.TimeDTO
import com.pnvpnvpnv.timetesttask.domain.models.Time
import javax.inject.Inject

class TimeMapper @Inject constructor() {
    fun mapRemoteToDomain(remote: TimeDTO): Time = Time(
        hour = requireNotNull(remote.hour),
        minute = requireNotNull(remote.minute),
        second = requireNotNull(remote.seconds),
    )
}