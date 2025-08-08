package com.vint.app

class CalculateBulletUseCase(private val rules: GameRules) {
    fun invoke(round: Round, previous: List<Score>): List<Score> {
        val updates = mutableMapOf<String, Int>()
        round.results.forEach { (playerId, value) ->
            val prev = previous.find { it.playerId == playerId }?.total ?: 0
            updates[playerId] = prev + value * rules.bulletMultiplier
        }
        return updates.map { Score(it.key, it.value) }
    }
}
