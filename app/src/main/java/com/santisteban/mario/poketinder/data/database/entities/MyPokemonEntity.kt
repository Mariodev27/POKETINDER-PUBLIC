package com.santisteban.mario.poketinder.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class MyPokemonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "idPokemon") val idPokemon:String ,
    @ColumnInfo(name = "name") val name: String ,
    @ColumnInfo(name = "image") val image: String ,
    @ColumnInfo(name = "isLegendary") val isLegendary: Boolean = false ,
    @ColumnInfo(name = "position") val position: Int = -1
){
    //val pokemonEntity = MyPokemonEntity(id = 1,idPokemon = "01", name = "bulbasur", image = " +
        //""image")
}