
// ui/screens/VeterinariosScreen.kt


package com.example.appnila.ui.theme.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnila.ui.theme.Repository.VeterinariaRepository
import com.example.appnila.ui.theme.entities.Veterinario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VeterinariosScreen(navController: NavController, repository: VeterinariaRepository) {
    val veterinarios by repository.getAllVeterinarios().collectAsState(initial = emptyList())
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("👨‍⚕️ Veterinarios", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF9C27B0))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFF9C27B0),
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Nuevo Veterinario")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF3E5F5))
        ) {
            if (veterinarios.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color(0xFF9C27B0)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "No hay veterinarios registrados",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color(0xFF7B1FA2)
                        )
                        Text(
                            "Presiona + para agregar un nuevo veterinario",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFAB47BC)
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(veterinarios) { veterinario ->
                        VeterinarioCard(veterinario = veterinario)
                    }
                }
            }
        }
    }

    if (showDialog) {
        NuevoVeterinarioDialog(
            onDismiss = { showDialog = false },
            onConfirm = {
                // TODO: Implementar inserción
                showDialog = false
            }
        )
    }
}

@Composable
fun VeterinarioCard(veterinario: Veterinario) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = Color(0xFF9C27B0),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.size(48.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Dr. ${veterinario.nombre} ${veterinario.apellido}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6A1B9A)
                )
                Text(
                    text = veterinario.especialidad,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF666666),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = veterinario.telefono,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF888888)
                )
                Text(
                    text = "Lic: ${veterinario.licencia}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF4CAF50),
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
fun NuevoVeterinarioDialog(
    onDismiss: () -> Unit,
    onConfirm: (Veterinario) -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var especialidad by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var licencia by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nuevo Veterinario") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = apellido,
                    onValueChange = { apellido = it },
                    label = { Text("Apellido") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = especialidad,
                    onValueChange = { especialidad = it },
                    label = { Text("Especialidad") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = telefono,
                    onValueChange = { telefono = it },
                    label = { Text("Teléfono") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = licencia,
                    onValueChange = { licencia = it },
                    label = { Text("Número de Licencia") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (nombre.isNotBlank() && apellido.isNotBlank() && especialidad.isNotBlank()) {
                        val veterinario = Veterinario(
                            nombre = nombre,
                            apellido = apellido,
                            especialidad = especialidad,
                            telefono = telefono,
                            email = email,
                            licencia = licencia
                        )
                        onConfirm(veterinario)
                    }
                }
            ) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}



