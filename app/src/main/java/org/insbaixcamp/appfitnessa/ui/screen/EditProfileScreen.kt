package org.insbaixcamp.appfitnessa.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitnessa.model.Usuari
import org.insbaixcamp.appfitnessa.model.opcionsGenere
import org.insbaixcamp.appfitnessa.model.opcionsNivell
import org.insbaixcamp.appfitnessa.model.opcionsObjectiu
import org.insbaixcamp.appfitnessa.model.usuariInicial
import org.insbaixcamp.appfitnessa.ui.components.FotoPerfil
import org.insbaixcamp.appfitnessa.ui.components.MenuDesplegable
import org.insbaixcamp.appfitnessa.ui.theme.AppFitnessATheme

// Pantalla per editar el perfil.
// Fem una copia de les dades: si l'usuari prem Cancel·lar no es canvia res.
@Composable
fun EditProfileScreen(
    usuari: Usuari,
    onGuardar: (Usuari) -> Unit,
    onCancelar: () -> Unit
) {
    var nom by remember { mutableStateOf(usuari.nom) }
    var email by remember { mutableStateOf(usuari.email) }
    var genere by remember { mutableStateOf(usuari.genere) }
    // Els numeros els guardem com a text per poder escriure al camp sense problemes
    var edat by remember { mutableStateOf(usuari.edat.toString()) }
    var alcada by remember { mutableStateOf(usuari.alcada.toString()) }
    var pes by remember { mutableStateOf(usuari.pes.toString()) }
    var pesObjectiu by remember { mutableStateOf(usuari.pesObjectiu.toString()) }
    var objectiu by remember { mutableStateOf(usuari.objectiu) }
    var nivell by remember { mutableStateOf(usuari.nivellActivitat) }

    val campModifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Editar perfil", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FotoPerfil(mida = 90.dp)
        }

        // --- Dades personals ---
        Seccio("Dades personals")
        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom complet") },
            singleLine = true,
            modifier = campModifier
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = campModifier
        )
        OutlinedTextField(
            value = edat,
            onValueChange = { edat = it },
            label = { Text("Edat") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = campModifier
        )
        MenuDesplegable(
            label = "Gènere",
            opcions = opcionsGenere,
            seleccionat = genere,
            onSeleccionar = { genere = it },
            modifier = campModifier
        )

        // --- Dades fisiques ---
        Seccio("Dades físiques")
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = alcada,
                onValueChange = { alcada = it },
                label = { Text("Alçada (cm)") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
            )
            OutlinedTextField(
                value = pes,
                onValueChange = { pes = it },
                label = { Text("Pes (kg)") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
        }
        OutlinedTextField(
            value = pesObjectiu,
            onValueChange = { pesObjectiu = it },
            label = { Text("Pes objectiu (kg)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = campModifier
        )

        // --- Objectius ---
        Seccio("Objectius")
        MenuDesplegable(
            label = "Objectiu principal",
            opcions = opcionsObjectiu,
            seleccionat = objectiu,
            onSeleccionar = { objectiu = it },
            modifier = campModifier
        )
        MenuDesplegable(
            label = "Nivell d'activitat",
            opcions = opcionsNivell,
            seleccionat = nivell,
            onSeleccionar = { nivell = it },
            modifier = campModifier
        )

        Spacer(Modifier.height(16.dp))

        // Botons
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = onCancelar,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel·lar")
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {
                    // Si un numero esta mal escrit, deixem el valor que hi havia abans
                    val usuariNou = Usuari(
                        nom = nom,
                        email = email,
                        edat = edat.toIntOrNull() ?: usuari.edat,
                        genere = genere,
                        alcada = alcada.toIntOrNull() ?: usuari.alcada,
                        pes = pes.replace(",", ".").toDoubleOrNull() ?: usuari.pes,
                        pesObjectiu = pesObjectiu.replace(",", ".").toDoubleOrNull() ?: usuari.pesObjectiu,
                        objectiu = objectiu,
                        nivellActivitat = nivell
                    )
                    onGuardar(usuariNou)
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Guardar canvis")
            }
        }
    }
}

@Composable
private fun Seccio(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    AppFitnessATheme {
        EditProfileScreen(usuari = usuariInicial, onGuardar = {}, onCancelar = {})
    }
}
