package com.pnvpnvpnv.timetesttask.domain

import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<P, R>(
    private val executionContext: CoroutineContext,
    private val errorConverter: ErrorConverter
) {
    protected abstract suspend fun executeOnBackground(params: P): R

    suspend fun executeOrThrow(params: P): R {
        return withContext(executionContext) {
            try {
                executeOnBackground(params)
            } catch (t: Throwable) {
                throw errorConverter.convert(t)
            }
        }
    }
}