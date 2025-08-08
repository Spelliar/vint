package com.vint.app

import kotlinx.serialization.Serializable

@Serializable
data class Player(val id: String, val name: String)

@Serializable
data class Game(
    val id: String = "",
    val players: List<String>,
    val createdAt: Long = 0L
)

@Serializable
data class Round(
    val id: String = "",
    val gameId: String,
    val results: Map<String, Int>
)

@Serializable
data class Score(
    val playerId: String,
    val total: Int
)

class GameRules(val bulletMultiplier: Int = 1)
