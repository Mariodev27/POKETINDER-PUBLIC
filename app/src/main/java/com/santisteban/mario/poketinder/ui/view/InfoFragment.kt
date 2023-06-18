package com.santisteban.mario.poketinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.viewModels
import com.santisteban.mario.poketinder.databinding.FragmentInfoBinding
import com.santisteban.mario.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private val viewModel: InfoViewModel by viewModels()
    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.wvInfoFragment

        webView.settings.javaScriptEnabled = true

        viewModel.getUrlPokemon().observe(viewLifecycleOwner){
            webView.loadUrl(it)
        }
    }
}