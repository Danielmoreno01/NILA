
// ui/screens/NuevaCitaScreen.kt
package com.example.appnila.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appnila.ui.theme.Repository.VeterinariaRepository
import java.util.Date
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaCitaScreen(navController: NavController, repository: VeterinariaRepository) {
    var mascotaId by remember { mutableStateOf("") }
    var veterinarioId by remember { mutableStateOf("") }
    var motivo by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }
    var fechaSeleccionada by remember { mutableStateOf("") }
    var horaSeleccionada by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("📝 Nueva Cita", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF43A047))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF1F8E9))
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Información de la Cita",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFF2E7D32),
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(
                        value = mascotaId,
                        onValueChange = { mascotaId = it },
                        label = { Text("ID de Mascota") },
                        placeholder = { Text("Ingrese el ID de la mascota") },
                        leadingIcon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF43A047),
                            focusedLabelColor = Color(0xFF43A047)
                        )
                    )

                    OutlinedTextField(
                        value = veterinarioId,
                        onValueChange = { veterinarioId = it },
                        label = { Text("ID de Veterinario") },
                        placeholder = { Text("Ingrese el ID del veterinario") },
                        leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF43A047),
                            focusedLabelColor = Color(0xFF43A047)
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = fechaSeleccionada,
                            onValueChange = { fechaSeleccionada = it },
                            label = { Text("Fecha") },
                            placeholder = { Text("DD/MM/YYYY") },
                            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF43A047),
                                focusedLabelColor = Color(0xFF43A047)
                            )
                        )

                        OutlinedTextField(
                            value = horaSeleccionada,
                            onValueChange = { horaSeleccionada = it },
                            label = { Text("Hora") },
                            placeholder = { Text("HH:MM") },
                            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF43A047),
                                focusedLabelColor = Color(0xFF43A047)
                            )
                        )
                    }

                    OutlinedTextField(
                        value = motivo,
                        onValueChange = { motivo = it },
                        label = { Text("Motivo de la consulta") },
                        placeholder = { Text("Describa el motivo de la consulta") },
                        leadingIcon = { Icon(Icons.Default.Create, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 2,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF43A047),
                            focusedLabelColor = Color(0xFF43A047)
                        )
                    )

                    OutlinedTextField(
                        value = observaciones,
                        onValueChange = { observaciones = it },
                        label = { Text("Observaciones (opcional)") },
                        placeholder = { Text("Observaciones adicionales") },
                        leadingIcon = { Icon(Icons.Default.List, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF43A047),
                            focusedLabelColor = Color(0xFF43A047)
                        )
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF43A047)
                    )
                ) {
                    Icon(Icons.Default.Close, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Cancelar")
                }

                Button(
                    onClick = {
                        if (mascotaId.isNotBlank() && veterinarioId.isNotBlank() && motivo.isNotBlank()) {
                            // TODO: Implementar guardado de cita
                            navController.navigateUp()
                        }
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF43A047)
                    )
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Guardar Cita")
                }
            }
        }
    }
}
