package com.example.pokedex.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokedex.ui.theme.MainPink
import com.example.pokedex.ui.theme.Poppins
import com.example.pokedex.viewModel.PokeListViewModel

@Composable
fun PokemonListDisplayArea(pokeListViewModel: PokeListViewModel, onCardClick: () -> Unit) {
    val pokemonsList = pokeListViewModel.pokemonsPager.collectAsLazyPagingItems()

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 41.dp, bottom = 40.dp, start = 40.dp, end = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        if (pokeListViewModel.state.displaySearch) {
            pokeListViewModel.state.pokemonSearched?.let {
                item {
                    PokemonCard(pokemon = it, modifier = Modifier.clickable {
                        pokeListViewModel.pokemonClicked(it)
                        onCardClick.invoke()
                    })
                }
            } ?: run {
                item {
                    Column {
                        Text(
                            text = "Ops",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            fontSize = 148.sp,
                            color = Color(0xFFBDBDBD)
                        )
                        Text(
                            text = "Este pokemon não está aqui ;(",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = Color(0xFFBDBDBD)
                        )
                    }

                }
            }
        } else {
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

                        pokemonsList[i]?.let {
                            PokemonCard(
                                it, modifier = Modifier
                                    .clickable {
                                        pokeListViewModel.pokemonClicked(it)
                                        onCardClick.invoke()
                                    }
                            )
                        }

                        pokemonsList[i + 1]?.let {
                            PokemonCard(
                                it, modifier = Modifier
                                    .clickable {
                                        pokeListViewModel.pokemonClicked(it)
                                        onCardClick.invoke()
                                    }
                            )
                        }

                        pokemonsList[i + 2]?.let {
                            PokemonCard(
                                it, modifier = Modifier
                                    .clickable {
                                        pokeListViewModel.pokemonClicked(it)
                                        onCardClick.invoke()
                                    }
                            )
                        }

                        pokemonsList[i + 3]?.let {
                            PokemonCard(
                                it, modifier = Modifier
                                    .clickable {
                                        pokeListViewModel.pokemonClicked(it)
                                        onCardClick.invoke()
                                    }
                            )
                        }

                        pokemonsList[i + 4]?.let { PokemonCard(
                            it, modifier = Modifier
                                .clickable {
                                    pokeListViewModel.pokemonClicked(it)
                                    onCardClick.invoke()
                                }
                        )  }
                    }
                }
            }
        }


    }
}
