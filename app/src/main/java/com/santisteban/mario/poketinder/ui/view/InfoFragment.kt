package com.santisteban.mario.poketinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import com.santisteban.mario.poketinder.R
import com.santisteban.mario.poketinder.databinding.FragmentInfoBinding

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate){

    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val url = "https://pokemongolive.com/es/"
        webView = binding.wvInfoFragment
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

}