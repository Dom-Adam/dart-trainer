package com.example.darttrainer.data.game

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalGameDataSource @Inject constructor(private val gameDao: GameDao) : GameDataSource {
    override suspend fun insertGame(game: Game): Long {
        return gameDao.insertGame(game)
    }

    override suspend fun updateGame(dart: Dart): Long {
        return gameDao.updateGame(dart)
    }

    override fun readGameWithDarts(gameId: Long): Flow<GameWithDarts> {
        return gameDao.readGameWithDarts(gameId)
    }

    override fun readGame(gameId: Long): Flow<Game> {
        return gameDao.readGame(gameId)
    }
}