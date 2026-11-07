package com.example.gestindetareas.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gestindetareas.R
import com.example.gestindetareas.data.Tarea
import com.tuempresa.gestiontareas.data.DataSource

@Composable
fun Tarjeta(
    tarea: Tarea,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
//Variable para controlar los estilos según el estado de la tarjeta
    val estiloCard = if(tarea.completado) colorResource(R.color.color_tarjeta) else Color.Transparent
    val estiloTexto = if(tarea.completado)  colorResource(R.color.color_letra_normal) else  colorResource(R.color.black)

    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onClick(tarea.id) },
       colors = CardDefaults.cardColors(containerColor = estiloCard
       ),

        ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                tarea.titulo,
                color = estiloTexto,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                tarea.descripcion,
                color = estiloTexto,
                fontSize = 11.sp
            )
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(stringResource(R.string.fecha_tope, tarea.fechaTope),
                    color = estiloTexto
                )

                Row(modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically
                    ){
                    if(tarea.completado){

                        Text( "✅ Completada",
                        color = estiloTexto
                        )
                    }else{
                        Text( "❌ Pendiente",
                            color = colorResource(R.color.color_letra_pendiente)
                        )
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true, name = "tarjeta pendiente")
@Composable
fun TarjetaPendientePreview() {
    val tareaPendiente = DataSource.listaTareas[13]

    Tarjeta(
        tareaPendiente,
        onClick = {})
}

@Preview(showBackground = true, name = "tarjeta completada")
@Composable
fun TarjetaCompletadaPreview() {
    val tareaCompletada = DataSource.listaTareas[14]

    Tarjeta(
        tareaCompletada,
        onClick = {})
}