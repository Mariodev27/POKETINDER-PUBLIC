package com.santisteban.mario.poketinder.data.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse (
    @SerializedName("count_number") val count: Int,
    @SerializedName("results") val results: List<PokemonResponse>
)

