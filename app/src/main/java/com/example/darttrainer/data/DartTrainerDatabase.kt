package com.example.darttrainer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.darttrainer.data.game.Dart
import com.example.darttrainer.data.game.Game
import com.example.darttrainer.data.game.GameDao

@Database(
    entities = [Game::class, Dart::class],
    version = 1,
    exportSchema = false
)
abstract class DartTrainerDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}