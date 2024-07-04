package com.example.ec2_huancas_david.Ejercicio02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun obtenerEventos(): List<Evento> {
    return listOf(
        Evento("copa america", "", "2024-07-01"),
        Evento("copa del mundo", "Descripción del evento 2", "2024-07-02"),
        Evento("euro copa", "Descripción del evento 3", "2024-07-03"),
        Evento("mis peru", "Descripción del evento 4", "2024-07-04"),
        Evento("liga 1", "Descripción del evento 5", "2024-07-05"),
        Evento("Premier", "Descripción del evento 6", "2024-07-06"),
        Evento("Champios leage", "Descripción del evento 7", "2024-07-07"),
        Evento("liga 01 españa ", "Descripción del evento 8", "2024-07-08"),
        Evento("liga rey", "Descripción del evento 9", "2024-07-09"),
        Evento("liga seria italia", "Descripción del evento 10", "2024-07-10"),
        Evento("liga MLS", "Descripción del evento 11", "2024-07-11"),
        Evento("compa sudamericana", "Descripción del evento 12", "2024-07-12")
    )
}

@Composable
fun EventoCard(evento: Evento) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = evento.titulo, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = evento.descripcion, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = evento.fecha, style = MaterialTheme.typography.bodySmall)
        }
    }
}
@Composable
fun ListadoEventos() {
    val eventos = obtenerEventos()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(eventos) { evento ->
            EventoCard(evento)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewListadoEventos() {
    ListadoEventos()
}