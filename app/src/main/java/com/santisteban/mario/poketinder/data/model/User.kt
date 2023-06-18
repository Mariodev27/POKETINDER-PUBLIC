package com.santisteban.mario.poketinder.data.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String
) : java.io.Serializable {
    fun getImage() = "https://graph.facebook.com/$id/picture?type=large&width=720&height=720"
}
