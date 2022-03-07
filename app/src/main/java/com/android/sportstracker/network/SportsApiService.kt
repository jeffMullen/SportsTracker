package com.android.sportstracker.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://www.thesportsdb.com/api/v1/json/50130162/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SportsApiService {
    @GET("search_all_teams.php?")
    suspend fun getTeams(): List<Team>
}

object SportsApi {
    val retrofitService: SportsApiService by lazy {
        retrofit.create(SportsApiService::class.java)
    }
}