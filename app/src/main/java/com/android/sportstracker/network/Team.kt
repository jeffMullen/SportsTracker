package com.android.sportstracker.network

import com.squareup.moshi.Json

data class Team (
        val id: String,
        @Json(name = "team_name") val teamName: String
        )