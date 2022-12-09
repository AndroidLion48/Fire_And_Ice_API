package com.eaglewarrior.gameofthronesinfoapp.repository

import com.eaglewarrior.gameofthronesinfoapp.network.NetworkLayer.apiClient
import com.eaglewarrior.gameofthronesinfoapp.repository.models.CharacterModel

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): CharacterModel? {
        val request = apiClient.getCharacterById(characterId)

        if (!(!request.isSuccessful || request.body() == null)) {
            return request.body()
        }

        return null
    }

}
