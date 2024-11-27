package com.example.app_listatareas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisenioTarea(
    tarea: Tarea,
    cambioEstado: () -> Unit,
    cambioPrioridad: (Prioridad) -> Unit
) {
    Card() {
        Row(modifier = Modifier.background(Color.Black)) {
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = when (tarea.prioridad) {
                            Prioridad.ALTA -> Color(0xFFfd7300)
                            Prioridad.MEDIA -> Color(0xFF22fd00)
                            Prioridad.BAJA -> Color(0xFF2cb0b9)
                        }
                    )
                }, modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Sharp.Star,
                    contentDescription = "prioridad",
                    tint = when (tarea.prioridad) {
                        Prioridad.ALTA -> Color(0xFFfd7300)
                        Prioridad.MEDIA -> Color(0xFF22fd00)
                        Prioridad.BAJA -> Color(0xFF2cb0b9)
                    },

                )
            }
            Column (modifier = Modifier.weight(1f).padding(12.dp,0.dp,0.dp,0.dp)){
                Text(text = tarea.nombre, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold,
                     fontSize = 18.sp, color = Color.White)
                Text(text = if (tarea.completado) "Completada" else "Pendiente", fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Monospace, fontSize = 14.sp, color = Color.White)
            }
            MenuTarea(
                cambioEstado= cambioEstado,
                cambioPrioridad = cambioPrioridad
            )
        }
    }
}