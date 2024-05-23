package com.santisteban.mario.poketinder.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.santisteban.mario.poketinder.R

class  FirebaseRemoteConfigRepository {
    val instance = FirebaseRemoteConfig.getInstance()

    val getUrlPokemonLiveData: MutableLiveData<String> = MutableLiveData()
    val isUnderMaintenanceLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun init(){
        instance.setDefaultsAsync(R.xml.remote_config_defaults)
        instance.fetchAndActivate().addOnCompleteListener{task ->
            if(task.isSuccessful){
                getUrlPokemonLiveData.value = getUrlPokemonLive()
                isUnderMaintenanceLiveData.value = getIsUnderMaintenance()
            }
        }
    }

    private fun getUrlPokemonLive(): String{
        return instance["url_pokemon_live"].asString()
    }

    private fun getIsUnderMaintenance(): Boolean{
        return instance["is_under_maintance"].asBoolean()
    }

    //LAB12-FUE CONSOLA EN FIREBASE TEST LAB
}