package com.example.darttrainer.data.game

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.darttrainer.data.DartTrainerDatabase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class GameDaoTest {
    private lateinit var gameDao: GameDao
    private lateinit var db: DartTrainerDatabase

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DartTrainerDatabase::class.java
        ).build()
        gameDao = db.gameDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertGameTest() = runTest {
        val game = Game(name = "100 Darts")
        val result = gameDao.insertGame(game)

        assertThat(gameDao.readGame(gameId = result).first()).isEqualTo(
            Game(
                name = "100 Darts",
                gameId = result
            )
        )
    }

    @Test
    @Throws(Exception::class)
    fun updateGameTest() = runTest {
        val game = Game(name = "Boomerang")
        val gameId = gameDao.insertGame(game)
        val dartId =
            gameDao.updateGame(Dart(field = 20, segment = 3, value = 60, dartGameId = gameId))

        assertThat(gameDao.readGameWithDarts(gameId).first()).isEqualTo(
            GameWithDarts(
                game = Game(gameId = gameId, name = "Boomerang"),
                darts = listOf(
                    Dart(
                        field = 20,
                        segment = 3,
                        value = 60,
                        dartGameId = gameId,
                        dartId = dartId
                    )
                ),
            )
        )
    }
}