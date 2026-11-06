package com.example.gestindetareas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gestindetareas.data.Tarea

@Composable
fun Tarjeta(
    tarea: Tarea,
    modifier: Modifier = Modifier,
    onClick: (Int)->Unit
) {
    Card(modifier = Modifier
        .padding(10.dp)
        ){
    Column(modifier = Modifier
        .background(color = Color.Green)) {
        Text(tarea.titulo)
    }
    }
}

@Preview(showBackground = true, name ="tarjeta pendiente")
@Composable
fun TarjetaPendientePreview(){
    val tareaFalsa =Tarea(
    id = 1,
    titulo = "Haz algo bueno por alguien que te importa",
    descripcion = "Dedica un momento a demostrar tu aprecio hacia alguien especial. Puede ser un pequeño gesto, una llamada, un regalo o simplemente escuchar. Las acciones sinceras fortalecen vínculos y mejoran el bienestar emocional de ambas personas involucradas en el acto.",
    completado = false,
    fechaTope = "19/12/2026"
    )

    Tarjeta(tareaFalsa,
        onClick ={})
}

@Preview(showBackground = true, name ="tarjeta completada")
@Composable
fun TarjetaCompletadaPreview(){
    val tareaFalsa = Tarea(
        id = 2,
        titulo = "Memorizar un poema",
        descripcion = "Escoge un poema que te inspire o emocione y apréndelo de memoria. Este ejercicio mejora la concentración, estimula la memoria y fomenta una conexión más profunda con el lenguaje y las emociones transmitidas por la literatura clásica o contemporánea.",
        completado = true,
        fechaTope = "05/04/2025"
    )

    Tarjeta(tareaFalsa,
        onClick ={})
}