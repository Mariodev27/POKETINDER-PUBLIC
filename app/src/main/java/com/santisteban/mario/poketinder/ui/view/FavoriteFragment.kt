package com.santisteban.mario.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.santisteban.mario.poketinder.data.database.entities.MyPokemonEntity
import com.santisteban.mario.poketinder.databinding.FragmentFavoriteBinding
import com.santisteban.mario.poketinder.ui.adapter.MyPokemonsAdapter
import com.santisteban.mario.poketinder.ui.viewmodel.FavoriteViewModel

class FavoriteFragment : BaseFragment <FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private var listMyPokemon = mutableListOf<MyPokemonEntity>()

    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())
        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonList.observe(this){
            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener{
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
    }
}