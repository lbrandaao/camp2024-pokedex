package com.example.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.MainPink
import com.example.pokedex.ui.theme.Poppins

@Composable
fun PokeListScreen() {
    var pokemonSearchText by remember { mutableStateOf("Teste") }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(17.dp)
            .background(color = MainPink)
        ){}

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 40.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            
        ){
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.padding(start = 8.dp))

                Image(
                    painter = painterResource(id = R.drawable.logo_colorido),
                    contentDescription = "Logo Ioasys",
                    modifier = Modifier.size(width = 27.dp, height = 32.dp)
                )

                Text(text = "ioasys pokédex", fontSize = 24.sp,
                    modifier = Modifier.padding(start = 13.dp),
                    color = MainPink,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold
                )
            }

            Switch(checked = false,
                onCheckedChange = {},
                modifier = Modifier
                    .size(width = 39.dp, height = 27.dp),
                colors = SwitchDefaults.colors(
                    uncheckedBorderColor = MainPink,
                    uncheckedTrackColor = Color.Transparent,
                    uncheckedThumbColor = Color(0xFF8D8B92)
                )
            )
        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 51.dp, start = 40.dp, end = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            OutlinedTextField(
                value = pokemonSearchText,
                placeholder = {
                    Text(text = "Buscar pokemon")
                },
                onValueChange = { pokemonSearchText = it },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "Ícone de busca",
                        tint = MainPink)
                },
                label = {
                    Text(text = "Buscar",
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MainPink)
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MainPink,
                    focusedBorderColor = MainPink,
                    unfocusedTextColor = Color(0xFF666666),
                    focusedTextColor = Color(0xFF666666)
                )
            )

            Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "Ícone clicável",
                tint = MainPink,
                modifier = Modifier.size(24.dp)
                )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokeListScreenPreview() {
    PokeListScreen()
}