package com.santisteban.mario.poketinder.ui.view

import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.santisteban.mario.poketinder.databinding.ActivitySplashBinding
import com.santisteban.mario.poketinder.ui.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel.getIsUnderMaintenance().observe(this){isUnderMaintenance ->
            if(isUnderMaintenance){
                Toast.makeText(this,"Bajo Mantenimiento", Toast.LENGTH_SHORT).show()
            }else{
                showAnimation()
            }
        }
    }

    private fun showAnimation(){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        }, 3000)
    }
}