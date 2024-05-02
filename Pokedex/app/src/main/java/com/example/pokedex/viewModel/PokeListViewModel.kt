package com.example.pokedex.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.remote.PokemonRepository
import com.example.pokedex.data.remote.responses.Pokemon
import kotlinx.coroutines.launch

class PokeListViewModel : ViewModel() {
    private val pokemonRepository = PokemonRepository()
    var state by mutableStateOf(PokeListScreenState())

    init {
        viewModelScope.launch {
            val response = pokemonRepository.getPokemonList(state.limit, state.offset)
            state = state.copy(
                pokemonsList = response
            )
        }
    }

}

data class PokeListScreenState(
    val pokemonsList: List<Pokemon> = listOf(),
    val limit: Int = 15,
    val offset: Int = 0
)