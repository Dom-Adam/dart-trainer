package com.example.darttrainer.gameScreens.fourToOne.catch40

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class Catch40ViewModelTest {

    private lateinit var viewModel: Catch40ViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = Catch40ViewModel()
    }

    @Test
    fun testInit() {
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(61)
    }

    @Test
    fun clickHandler_3_returns3PointsNextTarget() {
        viewModel.clickHandler(3)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(3)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(62)
    }

    @Test
    fun clickHandler_2_returns2PointsNextTarget() {
        viewModel.clickHandler(2)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(2)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(62)
    }

    @Test
    fun clickHandler_1_returns1PointNextTarget() {
        viewModel.clickHandler(1)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(62)
    }

    @Test
    fun clickHandler_0_returns0PointsNextTarget() {
        viewModel.clickHandler(0)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(62)
    }

    @Test
    fun test() {
        viewModel.setLastTarget()

        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun testIfGameFinishesNotAt100() {
        viewModel.setLastTarget()

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isNotEqualTo(true)
    }

    @Test
    fun testIfGameFinishes() {
        viewModel.setLastTarget()
        viewModel.clickHandler(0)

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isEqualTo(true)
    }
}