package com.example.pokedex.data.remote.responses

data class PokemonListPage(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)