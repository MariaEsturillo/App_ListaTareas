package com.example.app_listatareas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListaTareas(){
    val listaTareas = remember { mutableStateListOf(
        Tarea("Hacer práctica DI", Prioridad.ALTA,false),
        Tarea("Hacer práctica AD", Prioridad.MEDIA,false),
        Tarea("Hacer práctica PMDM", Prioridad.BAJA,false),
        Tarea("Hacer práctica PSP", Prioridad.MEDIA,true),
    ) }

    Scaffold (
        topBar = { TopAppBar(title = { Text(text = "Tareas", textDecoration = TextDecoration.LineThrough, fontWeight = FontWeight.Black, fontFamily = FontFamily.Cursive, fontSize = 40.sp) }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        )) },

    ) {
            contentPadding ->
        Box(modifier = Modifier.padding(contentPadding).background(Color.Black)) {
            ListaTareas(
                tareas = listaTareas,
                cambioEstadoTarea = { tarea ->
                    val indice = listaTareas.indexOf(tarea)
                    if(indice != -1){
                        listaTareas[indice] = tarea.copy(completado = !tarea.completado)
                    }
                },
                cambioPrioridadTarea = { tarea, nprioridad ->
                    val indice = listaTareas.indexOf(tarea)
                    if(indice != -1){
                        listaTareas[indice] = tarea.copy(prioridad = nprioridad)

                    }
                }
            )
        }
    }
}