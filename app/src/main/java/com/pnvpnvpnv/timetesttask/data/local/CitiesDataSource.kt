package com.pnvpnvpnv.timetesttask.data.local

import com.pnvpnvpnv.timetesttask.R
import com.pnvpnvpnv.timetesttask.data.models.CityDTO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CitiesDataSource @Inject constructor() {
    fun getCities() = listOf(
        CityDTO(
            nameRes = R.string.bishkek,
            timeZoneName = "$ASIA/$BISHKEK"
        ),
        CityDTO(
            nameRes = R.string.belgrade,
            timeZoneName = "$EUROPE/$BELGRADE"
        ),
        CityDTO(
            nameRes = R.string.berlin,
            timeZoneName = "$EUROPE/$BERLIN"
        ),
        CityDTO(
            nameRes = R.string.ottawa,
            timeZoneName = "$AMERICA/$TORONTO"
        ),
        CityDTO(
            nameRes = R.string.johannesburg,
            timeZoneName = "$AFRICA/$JOHANNESBURG"
        )
    )

    companion object {
        private const val BISHKEK = "Bishkek"
        private const val BELGRADE = "Belgrade"
        private const val BERLIN = "Berlin"
        private const val TORONTO = "Toronto"
        private const val JOHANNESBURG = "Johannesburg"

        private const val ASIA = "Asia"
        private const val EUROPE = "Europe"
        private const val AMERICA = "America"
        private const val AFRICA = "Africa"
    }
}