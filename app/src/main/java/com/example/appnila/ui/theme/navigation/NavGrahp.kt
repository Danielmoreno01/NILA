package com.example.appnila.ui.theme.navigation


// ui/navigation/NavGraph.kt

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appnila.ui.screens.*
import com.example.appnila.ui.theme.Screen.DashboardScreen
import com.example.appnila.ui.theme.Screen.DuenosScreen
import com.example.appnila.ui.theme.Screen.VeterinariosScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: com.example.appnila.ui.theme.Repository.VeterinariaRepository
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Dashboard.route
    ) {
        composable(Routes.Dashboard.route) {
            DashboardScreen(navController)
        }

        composable(Routes.Agenda.route) {
            AgendaScreen(navController, repository)
        }

        composable(Routes.NuevaCita.route) {
            NuevaCitaScreen(navController, repository)
        }

        composable(Routes.Veterinarias.route) {
            VeterinariasScreen(navController, repository)
        }

        composable(Routes.Gestion.route) {
            GestionScreen(navController)
        }

        composable(Routes.Mascotas.route) {
            MascotasScreen(navController, repository)
        }

        composable(Routes.Duenos.route) {
            DuenosScreen(navController, repository)
        }

        composable(Routes.Veterinarios.route) {
            VeterinariosScreen(navController, repository)
        }

        composable(Routes.Configuracion.route) {
            ConfiguracionScreen(navController)
        }
    }
}
