package com.santisteban.mario.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santisteban.mario.poketinder.data.model.User
import com.santisteban.mario.poketinder.util.SharedPreferenceUtil

class LoginViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldAuthenticateError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate(){
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(email: String, password: String){
        if(email.isEmpty() || password.isEmpty()){
            emptyFieldsError.postValue( true)
        }

        val user: User? = sharedPreferenceUtil.getUser()

        if(email == user?.email && password == user.password){
            goSuccesActivity.postValue(true)
        }else{
            fieldAuthenticateError.postValue(true)
        }
    }
}
