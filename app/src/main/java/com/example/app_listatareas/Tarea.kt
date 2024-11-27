package com.example.app_listatareas

data class Tarea(
    val nombre : String,
    var prioridad : Prioridad,
    var completado : Boolean
)
