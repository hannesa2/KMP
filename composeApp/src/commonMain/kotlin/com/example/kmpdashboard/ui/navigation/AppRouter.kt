package com.example.kmpdashboard.ui.navigation

import androidx.compose.runtime.Composable
import com.example.kmpdashboard.ui.screens.DashboardDetailScreen
import com.example.kmpdashboard.ui.screens.DashboardScreen
import com.example.kmpdashboard.ui.screens.SettingsScreen

@Composable
fun AppRouter(
    route: Route,
    onNavigate: (Route) -> Unit,
    onLogout: () -> Unit
) {
    when (route) {
        is Route.Dashboard -> DashboardScreen(
            onOpenDetail = { itemId -> onNavigate(Route.DashboardDetail(itemId)) },
            onOpenSettings = { onNavigate(Route.Settings) },
            onLogout = onLogout
        )

        is Route.Settings -> SettingsScreen(
            onBack = { onNavigate(Route.Dashboard) }
        )

        is Route.DashboardDetail -> DashboardDetailScreen(
            itemId = route.itemId,
            onBack = { onNavigate(Route.Dashboard) }
        )

        is Route.Login -> Unit
    }
}
