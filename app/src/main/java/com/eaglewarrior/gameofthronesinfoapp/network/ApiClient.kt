package com.eaglewarrior.gameofthronesinfoapp.network

import com.eaglewarrior.gameofthronesinfoapp.repository.FireAndIceService
import com.eaglewarrior.gameofthronesinfoapp.repository.models.CharacterModel
import retrofit2.Response

/**
 * Created by Clarence E Moore on 2022-10-16.
 *
 * Description:
 *
 *
 */
class ApiClient(
    private val fireAndIceService: FireAndIceService
) {

    suspend fun getCharacterById(characterId: Int): Response<CharacterModel> {
        return fireAndIceService.getCharacterById(characterId)
    }
}
