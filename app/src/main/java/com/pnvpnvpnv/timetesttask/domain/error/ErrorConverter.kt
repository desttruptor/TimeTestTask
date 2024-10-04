package com.pnvpnvpnv.timetesttask.domain.error

import io.ktor.client.plugins.ResponseException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorConverter @Inject constructor() {
    fun convert(t: Throwable): Throwable {
        when (t) {
            is ResponseException -> throw NetworkError()
            is IllegalStateException -> throw MappingError()
            else -> throw GenericError()
        }
    }
}