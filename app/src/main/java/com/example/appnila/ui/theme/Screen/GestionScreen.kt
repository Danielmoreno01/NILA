
// ui/screens/GestionScreen.kt
package com.example.appnila.ui.screens

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
fun GestionScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("📋 Gestión de Datos", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF4511E))
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFFFF3E0), Color(0xFFFFE0B2))
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
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
                            text = "Gestión de Datos",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color(0xFFE65100),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Administra toda la información de tu clínica",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFFF7043),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        GestionCard(
                            title = "Mascotas",
                            description = "Gestionar información de mascotas",
                            icon = Icons.Default.Favorite,
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFF8BC34A), Color(0xFF9CCC65))
                            ),
                            onClick = { navController.navigate(Routes.Mascotas.route) }
                        )
                    }

                    item {
                        GestionCard(
                            title = "Dueños",
                            description = "Gestionar información de propietarios",
                            icon = Icons.Default.Person,
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFF03A9F4), Color(0xFF29B6F6))
                            ),
                            onClick = { navController.navigate(Routes.Duenos.route) }
                        )
                    }

                    item {
                        GestionCard(
                            title = "Veterinarios",
                            description = "Gestionar personal médico",
                            icon = Icons.Default.Info,
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFF9C27B0), Color(0xFFAB47BC))
                            ),
                            onClick = { navController.navigate(Routes.Veterinarios.route) }
                        )
                    }

                    item {
                        GestionCard(
                            title = "Historiales",
                            description = "Ver historiales médicos",
                            icon = Icons.Default.AddCircle,
                            color = Brush.linearGradient(
                                colors = listOf(Color(0xFFFF5722), Color(0xFFFF7043))
                            ),
                            onClick = { /* TODO: Implementar */ }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GestionCard(
    title: String,
    description: String,
    icon: ImageVector,
    color: Brush,
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
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
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
