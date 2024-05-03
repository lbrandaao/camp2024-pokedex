package com.example.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedex.auxclasses.PokeTypeColor
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.ui.theme.Poppins
import java.util.Locale

@Composable
fun PokemonCard(pokemon: Pokemon, modifier: Modifier) {
    Column(
        modifier = modifier
            .size(width = 105.dp, height = 105.dp)
            .border(
                width = 1.dp,
                color = PokeTypeColor.fromTypeString(pokemon.types[0].type.name)!!,
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "#"+String.format("%04d", pokemon.id),
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 3.dp),
            fontFamily = Poppins,
            fontSize = 8.sp,
            color = PokeTypeColor.fromTypeString(pokemon.types[0].type.name)!!
        )

        AsyncImage(
            model = pokemon.sprites.other.official_artwork.front_default,
            contentDescription = "Imagem de Pokémon",
            modifier = Modifier.size(60.dp)
            )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = PokeTypeColor.fromTypeString(pokemon.types[0].type.name)!!,
                    shape = RoundedCornerShape(
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = pokemon.name.replaceFirstChar{
                    if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
                },
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = Poppins,
                fontSize = 10.sp,
                color = Color.White
            )
        }
    }
}