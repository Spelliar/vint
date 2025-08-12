package ru.tsum.design.navigation

import androidx.navigation.NavHostController

object Navigator {

    private var navController: NavHostController? = null

    fun bind(navController: NavHostController) {
        if (this.navController == null) {
                     this.navController = navController
        }
    }

    fun unbind() {
        navController = null
    }

    fun navigate(route: Routes) {
        navController?.navigate(route)
    }

    fun back() {
        navController?.popBackStack()
    }
}
