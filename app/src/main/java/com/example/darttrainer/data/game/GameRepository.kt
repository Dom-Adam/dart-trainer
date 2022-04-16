package com.example.darttrainer.data.game

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val localGameDataSource: GameDataSource
) {

    suspend fun createGame(name: String): Long {
        return localGameDataSource.insertGame(Game(name = name))
    }

    suspend fun updateGame(dart: Dart) {
        localGameDataSource.updateGame(dart)
    }

    fun getGame(gameId: Long): Flow<GameWithDarts> {
        return localGameDataSource.readGameWithDarts(gameId)
    }
}