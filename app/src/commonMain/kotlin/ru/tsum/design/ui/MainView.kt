package ru.tsum.design.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.tsum.design.navigation.Routes


@Composable
fun MainView(onNavigation: (Routes) -> Unit) {
    MainViewContent(
        onNavigation = onNavigation
    )
}

@Composable
fun MainViewContent(
    onNavigation: (Routes) -> Unit
) {
    Text("MainView")
}