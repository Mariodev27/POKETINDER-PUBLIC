package com.santisteban.mario.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santisteban.mario.poketinder.data.model.User
import com.santisteban.mario.poketinder.util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val notequalspasswordError = MutableLiveData<Boolean>()
    val emptyFieldsError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate(){
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(username: String, email: String, password1: String, password2:String){
        if(email.isEmpty() || password1.isEmpty() || username.isEmpty() || password2.isEmpty()){
            emptyFieldsError.postValue( true)
        }
        if(password1 == password2){
            val user = User(
                "1",
                username,
                email,
                password1
            )
            sharedPreferenceUtil.saveUser(user)
            goSuccesActivity.postValue(true)
        }else{
            notequalspasswordError.postValue(true)
        }
    }
}
