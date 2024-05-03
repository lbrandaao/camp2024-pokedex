package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.viewModel.PokeListViewModel


class MainActivity : ComponentActivity() {

    private val pokemonListViewModel by viewModels<PokeListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            PokedexTheme {
                NavHost(navController = navController, startDestination = "pokelist") {
                    composable("pokelist") {
                        PokeListScreen(pokemonListViewModel) {
                            navController.navigate("pokemondetails")
                        }
                    }
                    
                    composable("pokemondetails") {
                        PokemonDetailsScreen(pokemon = pokemonListViewModel._pokemonClicked!!) {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}