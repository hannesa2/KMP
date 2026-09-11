package com.example.kmpdashboard

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.kmpdashboard.ui.navigation.AppRouter
import com.example.kmpdashboard.ui.navigation.Route
import com.example.kmpdashboard.ui.screens.LoginScreen

@Composable
fun App() {
    MaterialTheme {
        var isLoggedIn by remember { mutableStateOf(false) }
        var currentRoute by remember { mutableStateOf<Route>(Route.Login) }

        if (!isLoggedIn) {
            LoginScreen(
                onLogin = { username, password ->
                    if (username.isNotBlank() && password.isNotBlank()) {
                        isLoggedIn = true
                        currentRoute = Route.Dashboard
                    }
                }
            )
        } else {
            AppRouter(
                route = currentRoute,
                onNavigate = { currentRoute = it },
                onLogout = {
                    isLoggedIn = false
                    currentRoute = Route.Login
                }
            )
        }
    }
}
