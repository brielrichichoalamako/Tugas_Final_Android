package com.briel.tugas_final.Network

import com.briel.tugas_final.Model.Team
import retrofit2.Response
import retrofit2.http.GET

interface EndPoint {

    @GET("leagues/eng.1/standings")
    suspend fun getTeamStanding(): Response<Team>

}