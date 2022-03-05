package com.example.darttrainer.gameScreens.fourToOne.DoublesArroundTheWorld

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DoublesArroundTheWorldViewModelTest {

    private lateinit var viewModel: DoublesArroundTheWorldViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = DoublesArroundTheWorldViewModel()
    }

    @Test
    fun clickHandler_3_returns3AndNextTarget() {
        viewModel.clickHandler(3)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(3)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("2")
    }

    @Test
    fun clickHandler_2_returns2AndNextTarget() {
        viewModel.clickHandler(2)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(2)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("2")
    }

    @Test
    fun clickHandler_1_returns1AndNextTarget() {
        viewModel.clickHandler(1)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("2")
    }

    @Test
    fun clickHandler_0_returns0AndNextTarget() {
        viewModel.clickHandler(0)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("2")
    }

    @Test
    fun checkIfLastTargetNotSetsGameFinished() {
        viewModel.setToLastTarget()

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isFalse()
    }

    @Test
    fun checkIfGameFinishes() {
        viewModel.setToLastTarget()
        viewModel.clickHandler(0)

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }
}