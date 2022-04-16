package com.example.darttrainer.data.game

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class GameRepositoryTest {
    private lateinit var localGameDataSource: FakeGameDatasource
    private lateinit var gameRepository: GameRepository

    @Before
    fun createRepository() {
        localGameDataSource = FakeGameDatasource()
        gameRepository = GameRepository(localGameDataSource)
    }

    @Test
    fun createGameTest() = runTest {
        val gameId = gameRepository.createGame("Boomerang")

        assertThat(gameId).isEqualTo(1)
    }

    @Test
    fun updateGameTest() = runTest {
        val gameId = gameRepository.createGame("Boomerang")
        val dart = Dart(dartGameId = gameId, field = 20, segment = 3, value = 60)
        gameRepository.updateGame(dart)

        assertThat(gameRepository.getGame(gameId).first()).isEqualTo(
            GameWithDarts(
                Game(
                    gameId,
                    "Boomerang"
                ),
                listOf(dart)
            )
        )
    }
}