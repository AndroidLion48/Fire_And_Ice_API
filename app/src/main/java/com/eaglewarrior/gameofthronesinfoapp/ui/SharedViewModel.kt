package com.eaglewarrior.gameofthronesinfoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eaglewarrior.gameofthronesinfoapp.repository.SharedRepository
import com.eaglewarrior.gameofthronesinfoapp.repository.models.CharacterModel
import kotlinx.coroutines.launch

/**
 * Created by Clarence E Moore on 2022-10-16.
 *
 * Description:
 *
 *
 */
class SharedViewModel: ViewModel() {

    private val repository = SharedRepository()

    private val _characterByIdLiveData = MutableLiveData<CharacterModel?>()
    val characterByIdLiveData: LiveData<CharacterModel?> = _characterByIdLiveData

    fun refreshCharacter(characterId: Int) {
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)

            _characterByIdLiveData.postValue(response)
        }

    }
}
