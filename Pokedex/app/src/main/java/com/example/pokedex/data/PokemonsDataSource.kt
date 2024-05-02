package com.example.pokedex.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.data.remote.PokemonRepository
import com.example.pokedex.data.remote.responses.Pokemon

class PokemonsDataSource(
    private val repo: PokemonRepository
): PagingSource<Int, Pokemon>(){
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1)?:page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val page = params.key ?: 1
            val response = repo.getPokemonList(30, (page-1)*30)

            LoadResult.Page(
                data = response,
                prevKey = if (page==1) null else (page-1),
                nextKey = if (response.isEmpty()) null else page+1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}