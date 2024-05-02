package com.example.pokedex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.ui.theme.MainPink

@Composable
fun PokemonListDisplayArea(pokemonsList: List<Pokemon>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 40.dp, end = 40.dp, top = 41.dp, bottom = 49.dp),
        verticalArrangement = Arrangement.Top
    ) {

        if (pokemonsList.isEmpty()) {
            CircularProgressIndicator(
                color = MainPink,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        for (i in 0 until pokemonsList.size.coerceAtMost(15) step 3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                PokemonCard(pokemonsList[i])

                PokemonCard(pokemonsList[i+1])

                PokemonCard(pokemonsList[i+2])
            }
        }
    }
}