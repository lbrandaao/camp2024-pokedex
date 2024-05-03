package com.example.pokedex.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.auxclasses.PokeTypeColor
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.ui.theme.Poppins

@Composable
fun BoxPokemonStats(pokemon: Pokemon) {
    val pokemonTypeColor = PokeTypeColor.fromTypeString(pokemon.types[0].type.name)!!

    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Base Stats",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = pokemonTypeColor,
            modifier = Modifier.padding(bottom = 15.dp)
        )
    }
}