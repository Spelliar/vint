package com.spelliar.design.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Main : Routes
}
