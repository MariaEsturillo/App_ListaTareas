package com.example.app_listatareas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListaTareas(
    tareas : SnapshotStateList<Tarea>,
    cambioEstadoTarea :(Tarea) -> Unit,
    cambioPrioridadTarea : (Tarea, Prioridad) -> Unit
){
    Column (modifier = Modifier.fillMaxSize()
        .padding(20.dp,0.dp,20.dp,0.dp)
        .background(Color.Black)
        ){
        val tareasPendientes = tareas.filter { !it.completado }
        val tareasCompletadas = tareas.filter { it.completado }

        Text("Tareas pendientes",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(15.dp),
            color = Color.White
            )
        Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.padding(8.dp))

        LazyColumn (modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp)){

            items(tareasPendientes.size){ posicion ->
                DisenioTarea(
                    tarea = tareasPendientes[posicion],
                    cambioEstado = {cambioEstadoTarea(tareasPendientes[posicion])},
                    cambioPrioridad = {nprioridad ->
                        cambioPrioridadTarea(tareasPendientes[posicion], nprioridad)}
                )
            }
        }

        Text("Tareas completadas",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(15.dp),
            color = Color.White
        )
        Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.padding(8.dp))
        LazyColumn (modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp)){

            items(tareasCompletadas.size){ posicion ->
                DisenioTarea(
                    tarea = tareasCompletadas[posicion],
                    cambioEstado = {cambioEstadoTarea(tareasCompletadas[posicion])},
                    cambioPrioridad = {nprioridad ->
                        cambioPrioridadTarea(tareasCompletadas[posicion], nprioridad)}
                )
            }
        }

    }
}