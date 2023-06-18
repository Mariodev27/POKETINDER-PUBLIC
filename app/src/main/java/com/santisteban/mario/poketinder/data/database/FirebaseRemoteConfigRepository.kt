package com.santisteban.mario.poketinder.data.database

import androidx.lifecycle.MutableLiveData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.santisteban.mario.poketinder.R

class FirebaseRemoteConfigRepository {

    val instance = FirebaseRemoteConfig.getInstance()

    val getUrlPokemonLiveData: MutableLiveData<String> = MutableLiveData()
    val isUnderMaintenanceLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun init(){
        instance.setDefaultsAsync(R.xml.remote_config_defaults)
        instance.fetchAndActivate().addOnCompleteListener{task ->
            if(task.isSuccessful){
                getUrlPokemonLiveData.value
            }
        }
    }

    private fun getUrlPokemonLiveData(): String = instance["url_pokemon_live"].asString()

    private fun getisUnderMaintenance(): Boolean {
        return instance["is_under_maintance"].asBoolean()
    }
}