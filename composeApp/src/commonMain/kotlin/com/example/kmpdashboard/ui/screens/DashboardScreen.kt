package com.example.kmpdashboard.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    onOpenDetail: (Int) -> Unit,
    onOpenSettings: () -> Unit,
    onLogout: () -> Unit
) {
    val items = List(20) { index -> index + 1 }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                actions = {
                    TextButton(onClick = onOpenSettings) { Text("Settings") }
                    TextButton(onClick = onLogout) { Text("Logout") }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items) { id ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onOpenDetail(id) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Dashboard Item #$id", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(4.dp))
                        Text("Tap to open details", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
