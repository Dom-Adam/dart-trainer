package com.example.darttrainer.data.game

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGameDatasource : GameDataSource {
    val dartList = mutableListOf<Dart>()
    val gameList = mutableListOf<Game>()
    var games = mutableListOf<GameWithDarts>()

    override suspend fun insertGame(game: Game): Long {
        val id = (gameList.size + 1).toLong()
        gameList.add(game.copy(gameId = id))
        return id
    }

    override suspend fun updateGame(dart: Dart): Long {
        dartList.add(dart)
        return dart.dartGameId
    }

    override fun readGameWithDarts(gameId: Long): Flow<GameWithDarts> {
        return flow {
            gameList.find { game -> game.gameId == gameId }?.let {
                emit(
                    GameWithDarts(
                        it,
                        darts = dartList.filter { dart -> dart.dartGameId == gameId },
                    )
                )
            }
        }
    }

    override fun readGame(gameId: Long): Flow<Game> {
        TODO("Not yet implemented")
    }
}