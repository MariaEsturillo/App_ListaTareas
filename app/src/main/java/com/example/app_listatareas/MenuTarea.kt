package com.example.app_listatareas

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun MenuTarea(
    cambioEstado: () -> Unit,
    cambioPrioridad: (Prioridad) -> Unit
) {
    var abierto by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { abierto = true }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "menu",
                tint = Color.White
            )
        }
        DropdownMenu(expanded = abierto, onDismissRequest = { abierto = false }) {
            DropdownMenuItem(text = { Text("Tarea Completada" )}, onClick = {
                cambioEstado()
                abierto = false
            })

            DropdownMenuItem(text = { Text("Prioridad Alta") }, onClick = {
                cambioPrioridad(Prioridad.ALTA)
                abierto = false
            })

            DropdownMenuItem(text = {Text("Prioridad Media" )}, onClick = {
                cambioPrioridad(Prioridad.MEDIA)
                abierto = false
            })

            DropdownMenuItem(text = {Text("Prioridad Baja")}, onClick = {
                cambioPrioridad(Prioridad.BAJA)
                abierto = false
            })
        }
    }
}