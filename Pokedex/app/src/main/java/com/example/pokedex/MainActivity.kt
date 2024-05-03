package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                        PokeListScreen(pokemonListViewModel)
                    }
                }
            }
        }
    }
}