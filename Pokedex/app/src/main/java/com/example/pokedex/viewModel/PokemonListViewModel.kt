package com.example.pokedex.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pokedex.data.PokemonsDataSource
import com.example.pokedex.data.remote.PokemonRepository
import com.example.pokedex.data.remote.responses.Pokemon
import kotlinx.coroutines.launch

class PokeListViewModel : ViewModel() {
    private val pokemonRepository = PokemonRepository()
    var state by mutableStateOf(PokeListScreenState())
    var _pokemonClicked: Pokemon? = null

    val pokemonsPager = Pager(
        PagingConfig(pageSize = 30)
    ) {
        PokemonsDataSource(pokemonRepository)
    }.flow.cachedIn(viewModelScope)

    fun searchByName(name: String) {
        viewModelScope.launch {
           val response = pokemonRepository.getPokemonInfo(name.lowercase())
           state = state.copy(
               displaySearch = true,
               pokemonSearched = response
           )
        }
    }
    fun displayAllPokemons() {
        viewModelScope.launch {
            state = state.copy(
                displaySearch = false,
                pokemonSearched = null
            )
        }
    }

    fun pokemonClicked(pokemon: Pokemon) {
        _pokemonClicked = pokemon
    }
}

data class PokeListScreenState(
    val displaySearch: Boolean = false,
    val pokemonSearched: Pokemon? = null
)