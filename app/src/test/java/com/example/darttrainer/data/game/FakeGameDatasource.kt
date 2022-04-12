package com.example.darttrainer.data.game

import kotlinx.coroutines.flow.Flow

class FakeGameDatasource : GameDataSource {
    val games = mutableListOf<GameWithDarts>()

    override suspend fun insertGame(game: Game): Long {
        games.add(GameWithDarts(game = game, darts = emptyList()))
        return games.size.toLong()
    }

    override suspend fun updateGame(dart: Dart): Long {
        val darts = games[dart.dartGameId.toInt()].darts.toMutableList()
        darts.add(dart)
        return dart.dartGameId
    }

    override fun readGameWithDarts(gameId: Long): Flow<GameWithDarts> {
        TODO("Not yet implemented")
    }

    override fun readGame(gameId: Long): Flow<Game> {
        TODO("Not yet implemented")
    }
}