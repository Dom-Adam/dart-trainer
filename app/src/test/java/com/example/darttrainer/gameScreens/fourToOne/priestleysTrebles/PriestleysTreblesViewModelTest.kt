package com.example.darttrainer.gameScreens.fourToOne.priestleysTrebles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PriestleysTreblesViewModelTest {

    private lateinit var viewModel: PriestleysTreblesViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = PriestleysTreblesViewModel()
    }

    @Test
    fun clickHandler_3_returns3AndNextTarget() {
        viewModel.clickHandler(3)

        assertThat(viewModel.pointsScored.getOrAwaitValue()).isEqualTo(3)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(11)
    }

    @Test
    fun clickHandler_2_returns2AndNextTarget() {
        viewModel.clickHandler(2)

        assertThat(viewModel.pointsScored.getOrAwaitValue()).isEqualTo(2)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(11)
    }

    @Test
    fun clickHandler_1_returns1AndNextTarget() {
        viewModel.clickHandler(1)

        assertThat(viewModel.pointsScored.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(11)
    }

    @Test
    fun clickHandler_0_returns0AndNextTarget() {
        viewModel.clickHandler(0)

        assertThat(viewModel.pointsScored.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo(11)
    }

    @Test
    fun testIfLastTargetNotSetGameFinished() {
        viewModel.setLastTarget()

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isFalse()
    }

    @Test
    fun testIfGameFinishes() {
        viewModel.setLastTarget()
        viewModel.clickHandler(3)

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }
}