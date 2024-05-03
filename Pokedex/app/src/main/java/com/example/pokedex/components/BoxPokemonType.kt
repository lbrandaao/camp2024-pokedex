package com.example.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.auxclasses.PokeTypeColor
import com.example.pokedex.ui.theme.Poppins

@Composable
fun BoxPokemonType(type: String) {
    Box (
        modifier = Modifier
            .padding(end = 10.dp)
            .background(color = PokeTypeColor.fromTypeString(type)!!, shape = RoundedCornerShape(20.dp))
            .padding(vertical = 2.dp, horizontal = 10.dp)
    ){
        Text(
            text = type,
            color = Color.White,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}