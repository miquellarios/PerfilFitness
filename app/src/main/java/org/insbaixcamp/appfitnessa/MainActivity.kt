package org.insbaixcamp.appfitnessa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.appfitnessa.model.Usuari
import org.insbaixcamp.appfitnessa.model.usuariInicial
import org.insbaixcamp.appfitnessa.ui.screen.EditProfileScreen
import org.insbaixcamp.appfitnessa.ui.screen.ProfileScreen
import org.insbaixcamp.appfitnessa.ui.theme.AppFitnessATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnessATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    // Dades de l'usuari en memoria
    var usuari: Usuari by remember { mutableStateOf(usuariInicial) }
    // Navegacio basica: si es true mostrem la pantalla d'editar
    var editant by remember { mutableStateOf(false) }

    if (editant) {
        EditProfileScreen(
            usuari = usuari,
            onGuardar = { usuariNou ->
                usuari = usuariNou
                editant = false
            },
            onCancelar = { editant = false }
        )
    } else {
        ProfileScreen(
            usuari = usuari,
            onEditar = { editant = true }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    AppFitnessATheme {
        FitnessApp()
    }
}
