package com.example.pokedex.viewModel

import android.util.Log
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

    val pokemonsPager = Pager(
        PagingConfig(pageSize = 30)
    ) {
        PokemonsDataSource(pokemonRepository)
    }.flow.cachedIn(viewModelScope)

    /*init {
        viewModelScope.launch {
            val response = pokemonRepository.getPokemonList(state.limit, state.offset)
            state = state.copy(
                pokemonsList = response
            )
        }
    }*/

    fun getPokemonListPaged(limit: Int, offset: Int){
        viewModelScope.launch {
            try {
                val response = pokemonRepository.getPokemonList(limit, offset)
                state = state.copy(
                    pokemonsList = response
                )
            } catch (e: Exception) {
                Log.i("PokeListViewModelError", "Erro na requisição de paginação")
            }
        }
    }
}

data class PokeListScreenState(
    val pokemonsList: List<Pokemon> = listOf(),
    val limit: Int = 75,
    val offset: Int = 0
)