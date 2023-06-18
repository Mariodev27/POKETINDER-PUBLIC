package com.santisteban.mario.poketinder.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PokemonResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) : Serializable {

    fun getPokemonId() = getIdPokemonFromUrl(url)

    fun getIdPokemonFromUrl(url: String) : String = url.split("/").toTypedArray()[6]

    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}

