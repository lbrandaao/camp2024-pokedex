package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.PokemonListPage
import com.example.pokedex.data.remote.responses.PokemonSpecie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeAPIService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonListPage>

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ) : Response<Pokemon>

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecie(
        @Path("name") name: String
    ) : Response<PokemonSpecie>
}