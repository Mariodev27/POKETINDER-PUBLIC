package com.santisteban.mario.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santisteban.mario.poketinder.data.FirebaseRemoteConfigRepository

class InfoViewModel : ViewModel() {
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getUrlPokemon(): MutableLiveData<String> {
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }
}