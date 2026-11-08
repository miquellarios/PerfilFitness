package org.insbaixcamp.appfitnessa.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitnessa.model.Usuari
import org.insbaixcamp.appfitnessa.model.usuariInicial
import org.insbaixcamp.appfitnessa.ui.components.DadaCard
import org.insbaixcamp.appfitnessa.ui.components.FotoPerfil
import org.insbaixcamp.appfitnessa.ui.theme.AppFitnessATheme

// Pantalla que mostra les dades del perfil
@Composable
fun ProfileScreen(usuari: Usuari, onEditar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Capçalera amb el titol i el boto d'editar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Perfil", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            IconButton(onClick = onEditar) {
                Icon(Icons.Default.Edit, contentDescription = "Editar perfil")
            }
        }

        // Foto, nom i email
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FotoPerfil()
            Spacer(Modifier.height(8.dp))
            Text(usuari.nom, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(usuari.email, color = Color.Gray)
        }

        Spacer(Modifier.height(16.dp))

        // Dades fisiques en targetes
        Row(modifier = Modifier.fillMaxWidth()) {
            DadaCard("Edat", "${usuari.edat}", Modifier.weight(1f))
            DadaCard("Alçada", "${usuari.alcada} cm", Modifier.weight(1f))
            DadaCard("Pes", "${usuari.pes} kg", Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            DadaCard("Gènere", usuari.genere, Modifier.weight(1f))
            DadaCard("Pes objectiu", "${usuari.pesObjectiu} kg", Modifier.weight(1f))
        }

        // Objectiu
        Titol("Objectiu")
        Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
            Text(usuari.objectiu, modifier = Modifier.padding(12.dp))
        }

        // Nivell d'activitat
        Titol("Nivell d'activitat")
        Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
            Text(usuari.nivellActivitat, modifier = Modifier.padding(12.dp))
        }
    }
}

@Composable
private fun Titol(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    AppFitnessATheme {
        ProfileScreen(usuari = usuariInicial, onEditar = {})
    }
}
