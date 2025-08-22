package com.example.appnila.ui.theme.navigation

// ========== Navegación ==========
// ui/navigation/Routes.kt

sealed class Routes(val route: String) {
    object Dashboard : Routes("dashboard")
    object Agenda : Routes("agenda")
    object NuevaCita : Routes("nueva_cita")
    object Veterinarias : Routes("veterinarias")
    object Gestion : Routes("gestion")
    object Mascotas : Routes("gestion/mascotas")
    object Duenos : Routes("gestion/duenos")
    object Veterinarios : Routes("gestion/veterinarios")
    object Configuracion : Routes("configuracion")
}
