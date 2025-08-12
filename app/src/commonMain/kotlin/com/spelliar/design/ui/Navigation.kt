package com.spelliar.design.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spelliar.design.navigation.Navigator
import com.spelliar.design.navigation.Routes

@Composable
fun Navigation() {
    Box(
        Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        val navController = rememberNavController()

        DisposableEffect(Unit) {
            Navigator.bind(navController)

            onDispose {
                Navigator.unbind()
            }
        }

        NavHost(
            navController = navController,
            startDestination = Routes.Main
        ) {
            composable<Routes.Main> {
                MainView(onNavigation = { route -> Navigator.navigate(route) })
            }
        }
    }
}
