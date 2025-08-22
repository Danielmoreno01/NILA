// ui/screens/ConfiguracionScreen.kt
package com.example.appnila.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguracionScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("⚙️ Configuración", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6A1B9A))
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF3E5F5))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Configuración de la App",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color(0xFF4A148C),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Personaliza tu experiencia en Veterinaria NILA",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF8E24AA),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Person,
                    title = "Perfil de Usuario",
                    subtitle = "Editar información personal",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Notifications,
                    title = "Notificaciones",
                    subtitle = "Configurar alertas y recordatorios",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Search,
                    title = "Privacidad y Seguridad",
                    subtitle = "Gestionar datos y permisos",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Check,
                    title = "Copia de Seguridad",
                    subtitle = "Respaldar datos locales",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Build,
                    title = "Tema de la App",
                    subtitle = "Cambiar apariencia y colores",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Person,
                    title = "Idioma",
                    subtitle = "Seleccionar idioma de la interfaz",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Add,
                    title = "Ayuda y Soporte",
                    subtitle = "Obtener asistencia técnica",
                    onClick = { /* TODO */ }
                )
            }

            item {
                ConfiguracionItem(
                    icon = Icons.Default.Info,
                    title = "Acerca de",
                    subtitle = "Información de la aplicación",
                    onClick = { /* TODO */ }
                )
            }
        }
    }
}

@Composable
fun ConfiguracionItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = Color(0xFF6A1B9A).copy(alpha = 0.1f),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(40.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = Color(0xFF6A1B9A),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF4A148C)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF666666)
                )
            }

            Icon(
                Icons.Default.Home,
                contentDescription = null,
                tint = Color(0xFF999999),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}