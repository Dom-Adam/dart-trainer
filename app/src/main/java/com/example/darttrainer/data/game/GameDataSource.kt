package com.example.darttrainer.data.game

import kotlinx.coroutines.flow.Flow

interface GameDataSource {
    suspend fun insertGame(game: Game): Long
    suspend fun updateGame(dart: Dart): Long
    fun readGameWithDarts(gameId: Long): Flow<GameWithDarts>
    fun readGame(gameId: Long): Flow<Game>
}