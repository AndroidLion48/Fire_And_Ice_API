package com.eaglewarrior.gameofthronesinfoapp.repository

import com.eaglewarrior.gameofthronesinfoapp.repository.models.CharacterModel
import com.eaglewarrior.gameofthronesinfoapp.repository.models.ContinentModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Clarence E Moore on 2022-10-16.
 *
 * Description:
 *
 *
 */
interface FireAndIceService {

    @GET("/api/v2/Characters")
    fun getCharacters(): Response<List<CharacterModel>>

    @GET("/api/v2/Characters/{id}")
    suspend fun getCharacterById(
        @Path("id") characterId: Int
    ): Response<CharacterModel>

    @GET("/api/v2/Continents")
    fun getContinents(): Call<List<ContinentModel>>

    @GET("/api/v2/Continents/{id}")
    fun getContinentById(
        @Path("id") id: Int
    ): Call<ContinentModel>
}
