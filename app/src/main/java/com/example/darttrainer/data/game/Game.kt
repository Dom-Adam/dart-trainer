package com.example.darttrainer.data.game

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true) val gameId: Long = 0,
    val name: String,
)

@Entity
data class Dart(
    @PrimaryKey(autoGenerate = true) val dartId: Long = 0,
    val dartGameId: Long,
    val field: Int,
    val segment: Int,
    val value: Int,
)

data class GameWithDarts(
    @Embedded val game: Game,
    @Relation(
        parentColumn = "gameId",
        entityColumn = "dartGameId"
    )
    val darts: List<Dart>
)
