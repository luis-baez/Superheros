package com.superheros.data.api

import com.superheros.data.model.superheros.SuperHerosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SuperherosService {

    @GET("characters")
    suspend fun getSuperheros(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Response<SuperHerosResponse>

}