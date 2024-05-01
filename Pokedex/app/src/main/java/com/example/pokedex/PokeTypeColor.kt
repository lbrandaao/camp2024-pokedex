package com.example.pokedex

import androidx.compose.ui.graphics.Color
enum class PokeTypeColor(val color: Color) {
    ROCK(Color(0xFFB69E31)),
    GHOST(Color(0xFF70559B)),
    STEEL(Color(0xFFB7B9D0)),
    WATER(Color(0xFF6493EB)),
    GRASS(Color(0xFF74CB48)),
    PSYCHIC(Color(0xFFFB5584)),
    ICE(Color(0xFF9AD6DF)),
    DARK(Color(0xFF75574C)),
    FAIRY(Color(0xFFE69EAC)),
    NORMAL(Color(0xFFAAA67F)),
    FIGHTING(Color(0xFFC12239)),
    FLYING(Color(0xFFA891EC)),
    POISON(Color(0xFFA43E9E)),
    GROUND(Color(0xFFDEC16B)),
    BUG(Color(0xFFA7B723)),
    FIRE(Color(0xFFF57D31)),
    ELECTRIC(Color(0xFFF9CF30)),
    DRAGON(Color(0xFF7037FF));

    companion object {
        fun fromTypeString(pokeType: String): Color? {
            return entries.find {
                it.name.equals(pokeType, ignoreCase = true)
            }?.color ?: Color.Gray
        }
    }
}