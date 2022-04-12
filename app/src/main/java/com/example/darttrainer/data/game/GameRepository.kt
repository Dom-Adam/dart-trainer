package com.example.darttrainer.data.game

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val localGameDataSource: GameDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun createGame(name: String): Long {
        return localGameDataSource.insertGame(Game(name = name))
    }
}