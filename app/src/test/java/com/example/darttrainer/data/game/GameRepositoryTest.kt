package com.example.darttrainer.data.game

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameRepositoryTest {
    private lateinit var localGameDataSource: FakeGameDatasource
    private lateinit var gameRepository: GameRepository

    @Before
    fun createRepository() {
        localGameDataSource = FakeGameDatasource()
        gameRepository = GameRepository(localGameDataSource, Dispatchers.Unconfined)
    }

    @Test
    fun createGameTest() = runTest {
        val gameId = gameRepository.createGame("Boomerang")

        assertThat(gameId).isEqualTo(1)
    }
}