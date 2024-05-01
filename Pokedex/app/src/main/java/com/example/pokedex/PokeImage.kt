package com.example.pokedex

enum class PokeImage(val id: Int) {
    ARON(R.drawable.aron),
    BULBASAUR(R.drawable.bulbasaur),
    BUTTERFREE(R.drawable.butterfree),
    CHARMANDER(R.drawable.charmander),
    DITTO(R.drawable.ditto),
    GASTLY(R.drawable.gastly),
    MEW(R.drawable.mew),
    PIKACHU(R.drawable.pikachu),
    SQUIRTLE(R.drawable.squirtle);

    companion object {
        fun fromName(pokeName: String): Int {
            return PokeImage.entries.find {
                it.name.equals(pokeName, ignoreCase = true)
            }?.id ?: R.drawable.silhouette
        }
    }
}