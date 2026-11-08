package org.insbaixcamp.appfitnessa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Foto de perfil rodona (de moment es una icona, encara no carreguem imatges)
@Composable
fun FotoPerfil(mida: Dp = 110.dp) {
    Box(
        modifier = Modifier
            .size(mida)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Foto de perfil",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(mida)
                .padding(16.dp)
        )
    }
}
