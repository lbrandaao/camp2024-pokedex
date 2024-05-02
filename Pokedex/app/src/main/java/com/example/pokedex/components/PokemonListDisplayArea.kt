package com.example.pokedex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.ui.theme.MainPink

@Composable
fun PokemonListDisplayArea(pokemonsList: LazyPagingItems<Pokemon>) {

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 41.dp, bottom = 40.dp, start = 40.dp, end = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        if (pokemonsList.itemCount == 0) {
            item {
                CircularProgressIndicator(
                    color = MainPink
                )
            }
        }

        for (i in 0 until pokemonsList.itemCount step 5) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    pokemonsList[i]?.let { PokemonCard(it) }

                    pokemonsList[i + 1]?.let { PokemonCard(it) }

                    pokemonsList[i + 2]?.let { PokemonCard(it) }

                    pokemonsList[i + 3]?.let { PokemonCard(it) }

                    pokemonsList[i + 4]?.let { PokemonCard(it) }
                }
            }
        }

    }
}
