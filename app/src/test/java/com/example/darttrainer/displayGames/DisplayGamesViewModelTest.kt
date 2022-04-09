package com.example.darttrainer.displayGames

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayGamesViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var displayGamesViewModel: DisplayGamesViewModel

    @Before
    fun setup() {
        displayGamesViewModel = DisplayGamesViewModel()
    }

    @Test
    fun testOnNavigateToScreen() {
        displayGamesViewModel.onNavigateToScreen("Boomerang")
        val navigateToGameVal = displayGamesViewModel.navigateToGame.getOrAwaitValue()

        assertThat(navigateToGameVal).isEqualTo("Boomerang")
    }

    @Test
    fun testOnNavigateToScreenComplete() {
        displayGamesViewModel.onNavigateToScreen("Boomerang")
        var navigateToGameVal = displayGamesViewModel.navigateToGame.getOrAwaitValue()
        assertThat(navigateToGameVal).isNotNull()

        displayGamesViewModel.onNavigateToScreenComplete()
        navigateToGameVal = displayGamesViewModel.navigateToGame.getOrAwaitValue()
        assertThat(navigateToGameVal).isNull()
    }
}