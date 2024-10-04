package com.pnvpnvpnv.timetesttask.data.network

import com.pnvpnvpnv.timetesttask.data.models.TimeDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import javax.inject.Inject

class TimeApiClient @Inject constructor(
    private val httpClient: HttpClient,
) {
    suspend fun fetchCurrentTime(timeZone: String): TimeDTO {
        return httpClient.get {
            url {
                path("api/time/current/zone")
                parameters.append("timeZone", timeZone)
            }
        }.body()
    }
}
