package ru.tsum.design.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Main : Routes
}
