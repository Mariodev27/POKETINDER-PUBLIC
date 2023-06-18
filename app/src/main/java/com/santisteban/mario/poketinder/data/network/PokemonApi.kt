package com.santisteban.mario.poketinder.data.network

import com.santisteban.mario.poketinder.data.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("?limit=20")
    suspend fun getPokemons(): Response<PokemonListResponse>
}