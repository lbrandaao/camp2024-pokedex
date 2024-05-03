package com.example.pokedex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.Poppins
import java.util.Locale

@Composable
fun BoxPokemonMeasurement(icon: Painter, measurementValue: Int, unitMeasurement: String, measurementName: String){
    Column (
        modifier = Modifier.size(width = 100.dp, height = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                painter = icon,
                contentDescription = "Ícone da medida",
                tint = Color(0xFF212121),
                modifier = Modifier.size(18.dp)
            )

            Text(
                text = String.format(
                    Locale("pt",
                        "BR"),
                    "%.1f",(measurementValue.toDouble()/10)) + " " + unitMeasurement,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFF212121),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        
        Text(
            text = measurementName,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color(0xFFB3B3B3),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}