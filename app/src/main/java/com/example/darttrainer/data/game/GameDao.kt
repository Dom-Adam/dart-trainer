package com.example.darttrainer.data.game

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game): Long

    @Insert
    suspend fun updateGame(dart: Dart): Long

    @Transaction
    @Query("SELECT * FROM Game WHERE gameId IS :gameId")
    fun readGameWithDarts(gameId: Long): Flow<GameWithDarts>

    @Query("SELECT * FROM Game WHERE gameId IS :gameId")
    fun readGame(gameId: Long): Flow<Game>
}