package com.pnvpnvpnv.timetesttask.domain.usecases

import com.pnvpnvpnv.timetesttask.domain.BaseFlowUseCase
import com.pnvpnvpnv.timetesttask.domain.error.ErrorConverter
import com.pnvpnvpnv.timetesttask.domain.repository.TimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClockTickerUseCase @Inject constructor(
    errorConverter: ErrorConverter,
    private val repository: TimeRepository
) : BaseFlowUseCase<GetClockTickerUseCase.Params, String>(
    executionContext = Dispatchers.Default,
    errorMapper = errorConverter,
) {

    override fun createFlow(params: Params): Flow<String> {
        return repository.getClockTickerFlow(
            hour = params.hour,
            minute = params.minute,
            second = params.second,
        )
    }

    data class Params(
        val hour: Int,
        val minute: Int,
        val second: Int,
    )
}