package com.vint.app

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class GameRepositoryImpl : GameRepository {
    private val db = Firebase.firestore

    override suspend fun fetchGames(): List<Game> =
        db.collection("games").get().documents.map { it.data(Game.serializer()) }

    override suspend fun saveGame(game: Game) {
        db.collection("games").document(game.id).set(game)
    }

    override suspend fun fetchRounds(gameId: String): List<Round> =
        db.collection("games").document(gameId).collection("rounds").get().documents.map { it.data(Round.serializer()) }

    override suspend fun saveRound(round: Round) {
        db.collection("games").document(round.gameId).collection("rounds").document(round.id).set(round)
    }
}
