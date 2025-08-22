package com.example.appnila.ui.theme.Screen


// ========== Pantallas Mejoradas ==========
// ui/screens/DashboardScreen.kt (ACTUALIZADA)

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnila.ui.theme.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "🐾",
                            fontSize = 24.sp,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Column {
                            Text(
                                "Veterinaria NILA",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Panel Principal",
                                color = Color.White.copy(alpha = 0.8f),
                                fontSize = 12.sp
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2E7D32)
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFF1F8E9),
                            Color(0xFFE8F5E8)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Tarjeta de bienvenida
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "¡Bienvenido!",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color(0xFF1B5E20),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Gestiona tu clínica veterinaria de forma fácil y eficiente",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF4CAF50),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }

                // Grid de opciones
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        DashboardCard(
                            title = "Agenda",
                            subtitle = "de Citas",
                            description = "Programa y gestiona consultas",
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFF43A047), Color(0xFF66BB6A))
                            ),
                            icon = Icons.Default.DateRange,
                            onClick = { navController.navigate(Routes.Agenda.route) }
                        )
                    }

                    item {
                        DashboardCard(
                            title = "Buscar",
                            subtitle = "Veterinarias",
                            description = "Encuentra clínicas cercanas",
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFF1E88E5), Color(0xFF42A5F5))
                            ),
                            icon = Icons.Default.LocationOn,
                            onClick = { navController.navigate(Routes.Veterinarias.route) }
                        )
                    }

                    item {
                        DashboardCard(
                            title = "Gestión",
                            subtitle = "de Datos",
                            description = "Mascotas, dueños y más",
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFFF4511E), Color(0xFFFF7043))
                            ),
                            icon = Icons.Default.Person,
                            onClick = { navController.navigate(Routes.Gestion.route) }
                        )
                    }

                    item {
                        DashboardCard(
                            title = "Configuración",
                            subtitle = "y Ajustes",
                            description = "Personaliza la app",
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFF6A1B9A), Color(0xFF8E24AA))
                            ),
                            icon = Icons.Default.Settings,
                            onClick = { navController.navigate(Routes.Configuracion.route) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DashboardCard(
    title: String,
    subtitle: String,
    description: String,
    color: Brush,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color, RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )

                Column {
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = subtitle,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = description,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        lineHeight = 14.sp
                    )
                }
            }
        }
    }
}
