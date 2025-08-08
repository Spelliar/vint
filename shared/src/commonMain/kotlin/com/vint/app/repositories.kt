package com.vint.app

interface GameRepository {
    suspend fun fetchGames(): List<Game>
    suspend fun saveGame(game: Game)
    suspend fun fetchRounds(gameId: String): List<Round>
    suspend fun saveRound(round: Round)
}

interface PlayerRepository {
    suspend fun fetchPlayers(): List<Player>
    suspend fun savePlayer(player: Player)
}
