package com.android.sportstracker.network

import com.squareup.moshi.Json

data class Team (
        val id: String,
        @Json(name = "strTeam") val strTeam: String,
        @Json(name = "strTeamLogo") val strTeamLogo: String
        )