package com.example.darttrainer.data.game

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game): Long
}