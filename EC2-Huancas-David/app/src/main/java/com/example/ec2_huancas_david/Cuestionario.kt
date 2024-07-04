package com.example.ec2_huancas_david

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejercicio01Cuestionario() {
    var habilidades by remember { mutableStateOf(Habilidades()) }
    var significanciaTrabajo by remember { mutableStateOf("") }
    var pagoTrabajo by remember { mutableStateOf("") }
    var trabajaBajoPresion by remember { mutableStateOf(false) }
    var oportunidadCrecimiento by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "AppIDAT") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon press */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = "CUESTIONARIO", style = MaterialTheme.typography.headlineSmall)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "1. Marque sus habilidades.")
                HabilidadesCheckboxes(habilidades) {
                    habilidades = it
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "2. ¿Cuán significativo es tu trabajo?")
                SignificanciaRadioButton(significanciaTrabajo) {
                    significanciaTrabajo = it
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "3. ¿Qué tan bien te pagan en el trabajo que haces?")
                PagoRadioButton(pagoTrabajo) {
                    pagoTrabajo = it
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "4. ¿Trabajas bajo presión?")
                Row {
                    RadioButton(
                        selected = trabajaBajoPresion,
                        onClick = { trabajaBajoPresion = true }
                    )
                    Text(text = "SI")
                    Spacer(modifier = Modifier.width(16.dp))
                    RadioButton(
                        selected = !trabajaBajoPresion,
                        onClick = { trabajaBajoPresion = false }
                    )
                    Text(text = "NO")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "5. ¿Tienes oportunidad de crecimiento en tu trabajo?")
                Row {
                    RadioButton(
                        selected = oportunidadCrecimiento,
                        onClick = { oportunidadCrecimiento = true }
                    )
                    Text(text = "SI")
                    Spacer(modifier = Modifier.width(16.dp))
                    RadioButton(
                        selected = !oportunidadCrecimiento,
                        onClick = { oportunidadCrecimiento = false }
                    )
                    Text(text = "NO")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { /* Handle button click */ }) {
                    Text(text = "Resolver")
                }
            }
        }
    )
}

@Composable
fun HabilidadesCheckboxes(
    habilidades: Habilidades,
    onHabilidadesChange: (Habilidades) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = habilidades.autoconocimiento,
                onCheckedChange = { onHabilidadesChange(habilidades.copy(autoconocimiento = it)) }
            )
            Text(text = "Autoconocimiento")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = habilidades.empatia,
                onCheckedChange = { onHabilidadesChange(habilidades.copy(empatia = it)) }
            )
            Text(text = "Empatía")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = habilidades.comunicacionAsertiva,
                onCheckedChange = { onHabilidadesChange(habilidades.copy(comunicacionAsertiva = it)) }
            )
            Text(text = "Comunicación asertiva")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = habilidades.tomaDeDecisiones,
                onCheckedChange = { onHabilidadesChange(habilidades.copy(tomaDeDecisiones = it)) }
            )
            Text(text = "Toma de decisiones")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = habilidades.pensamientoCritico,
                onCheckedChange = { onHabilidadesChange(habilidades.copy(pensamientoCritico = it)) }
            )
            Text(text = "Pensamiento crítico")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = habilidades.ninguno,
                onCheckedChange = { onHabilidadesChange(habilidades.copy(ninguno = it)) }
            )
            Text(text = "Ninguno")
        }
    }
}

@Composable
fun SignificanciaRadioButton(
    significanciaTrabajo: String,
    onSignificanciaChange: (String) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = significanciaTrabajo == "Mucho",
                onClick = { onSignificanciaChange("Mucho") }
            )
            Text(text = "Mucho")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = significanciaTrabajo == "Más o menos",
                onClick = { onSignificanciaChange("Más o menos") }
            )
            Text(text = "Más o menos")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = significanciaTrabajo == "Poco",
                onClick = { onSignificanciaChange("Poco") }
            )
            Text(text = "Poco")
        }
    }
}

@Composable
fun PagoRadioButton(
    pagoTrabajo: String,
    onPagoChange: (String) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = pagoTrabajo == "Bien",
                onClick = { onPagoChange("Bien") }
            )
            Text(text = "Bien")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = pagoTrabajo == "Regular",
                onClick = { onPagoChange("Regular") }
            )
            Text(text = "Regular")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = pagoTrabajo == "Mal",
                onClick = { onPagoChange("Mal") }
            )
            Text(text = "Mal")
        }
    }
}

data class Habilidades(
    val autoconocimiento: Boolean = false,
    val empatia: Boolean = false,
    val comunicacionAsertiva: Boolean = false,
    val tomaDeDecisiones: Boolean = false,
    val pensamientoCritico: Boolean = false,
    val ninguno: Boolean = false
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ejercicio01Cuestionario()
}