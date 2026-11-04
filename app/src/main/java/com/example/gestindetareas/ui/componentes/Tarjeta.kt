package com.example.gestindetareas.ui.componentes

import androidx.compose.runtime.Composable
import com.example.gestindetareas.data.Tarea

@Composable
fun Tarjeta(
    id: Int,
    titulo: String,
    descripcion: String,
    completado: Boolean,
    fechaTope: String,
    onTarjetaClick: (Int) -> Unit
) {
    // Diseño visual
}