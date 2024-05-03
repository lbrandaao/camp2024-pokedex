package com.example.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedex.auxclasses.PokeTypeColor
import com.example.pokedex.components.BoxPokemonMeasurement
import com.example.pokedex.components.BoxPokemonMoves
import com.example.pokedex.components.BoxPokemonType
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.ui.theme.Poppins
import java.util.Locale

@Composable
fun PokemonDetailsScreen(pokemon: Pokemon, onBackClick: () -> Unit) {
    val pokemonTypeColor = PokeTypeColor.fromTypeString(pokemon.types[0].type.name)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = pokemonTypeColor!!)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Ícone clicável para voltar para tela anterior",
                    tint = Color.White,
                    modifier = Modifier.clickable { onBackClick.invoke() }
                )
                Text(
                    text = pokemon.name.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
                    },
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }

            Text(
                text = "#" + String.format("%04d", pokemon.id),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White,
                textAlign = TextAlign.End
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, bottom = 150.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 150.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .padding(horizontal = 32.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Ícone de favoritar",
                    tint = Color.Red,
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .size(32.dp)
                        .align(Alignment.End)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 25.dp)
                ) {
                    pokemon.types.forEach {
                        BoxPokemonType(type = it.type.name)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BoxPokemonMeasurement(
                        icon = painterResource(id = R.drawable.weight),
                        measurementValue = pokemon.weight,
                        unitMeasurement = "kg",
                        measurementName = "Weight"
                    )

                    BoxPokemonMeasurement(
                        icon = painterResource(id = R.drawable.height),
                        measurementValue = pokemon.height,
                        unitMeasurement = "m",
                        measurementName = "Height"
                    )

                    BoxPokemonMoves(movesList = pokemon.moves)
                }

                Text(
                    text = "There is a plant seed on its back right from the day this Pokémon " +
                            "is born. The seed slowly grows larger.",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF212121),
                    modifier = Modifier.padding(top = 25.dp)
                )


            }
            AsyncImage(
                model = pokemon.sprites.other.official_artwork.front_default,
                contentDescription = "Imagem do Pokémon",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}