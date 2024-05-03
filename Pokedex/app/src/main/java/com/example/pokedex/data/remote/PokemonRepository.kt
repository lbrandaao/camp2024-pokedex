package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.responses.Pokemon

class PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        val pokemonListPage = RetrofitInstance.pokeAPIService.getPokemonList(limit, offset).body()

        val pokemonList = mutableListOf<Pokemon>()

        pokemonListPage?.results?.forEach { pokemonInfo ->
            val pokemonName = pokemonInfo.name
            val pokemon = getPokemonInfo(pokemonName)
            if (pokemon != null) pokemonList.add(pokemon)
        }

        return pokemonList
    }

    suspend fun getPokemonInfo(name: String) : Pokemon? {
        return RetrofitInstance.pokeAPIService.getPokemonInfo(name).body()
    }

    suspend fun getPokemonSpecieFlavorText(name: String) : String? {
        val pokemonSpecieResponse = RetrofitInstance.pokeAPIService.getPokemonSpecie(name).body()

        return pokemonSpecieResponse?.flavor_text_entries?.get(0)?.flavor_text
    }
}