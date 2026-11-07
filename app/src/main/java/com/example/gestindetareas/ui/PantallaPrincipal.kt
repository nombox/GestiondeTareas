package com.example.gestindetareas.ui

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gestindetareas.R
import com.example.gestindetareas.ui.components.Tarjeta
import com.example.gestindetareas.viewmodel.TareaViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(viewModel: TareaViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(topBar= {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.colo_fondo_topBar)
        ),
            title = {
                Row(modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.logo_app),
                        contentDescription = "Logo To Do",
                        modifier = Modifier
                            .size(45.dp)
                            .padding(end = 12.dp)
                    )
                    Column(){
                        Text("Gestión de Tareas",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp)
                        Text(
                            stringResource(R.string.pendientes, uiState.contador.toString()),
                            fontSize = 15.sp)
                    }

                }

            }

        )

    }) { contentPadding ->
        LazyColumn (
            modifier = Modifier
                .padding(contentPadding)
        ){
            items(uiState.tareas){
                tareaIndividual ->

                Tarjeta(tareaIndividual,
                    onClick = {
                        idDeTarea->
                        viewModel.cambiarEstadoTareas(idDeTarea)
                    })
            }
        }
    }

}




@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview(){
    PantallaPrincipal()
}