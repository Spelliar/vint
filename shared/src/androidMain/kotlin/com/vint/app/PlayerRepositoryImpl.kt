package com.vint.app

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class PlayerRepositoryImpl : PlayerRepository {
    private val db = Firebase.firestore

    override suspend fun fetchPlayers(): List<Player> =
        db.collection("players").get().documents.map { it.data(Player.serializer()) }

    override suspend fun savePlayer(player: Player) {
        db.collection("players").document(player.id).set(player)
    }
}
