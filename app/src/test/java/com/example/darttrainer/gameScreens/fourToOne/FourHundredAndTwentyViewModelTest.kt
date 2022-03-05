package com.example.darttrainer.gameScreens.fourToOne

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.gameScreens.fourToOne.fourHundredAndTwenty.FourHundredAndTwentyViewModel
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FourHundredAndTwentyViewModelTest {

    private lateinit var viewModel: FourHundredAndTwentyViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = FourHundredAndTwentyViewModel()
    }

    @Test
    fun clickHandler_2Times3Hits_returns18AndNextTarget() {
        viewModel.clickHandler(3)
        viewModel.clickHandler(3)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(18)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("3")
    }

    @Test
    fun clickHandler_2Times2Hits_returns12AndNextTarget() {
        viewModel.clickHandler(2)
        viewModel.clickHandler(2)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(12)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("3")
    }

    @Test
    fun clickHandler_2Times1Hit_returns6AndNextTarget() {
        viewModel.clickHandler(1)
        viewModel.clickHandler(1)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(6)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("3")
    }

    @Test
    fun clickHandler_noHits_returns0AndNextTarget() {
        viewModel.clickHandler(0)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("2")
    }

    @Test
    fun testLastTargetNotSetsGameFinished() {
        viewModel.setToLastTarget()

        assertThat(viewModel.currentTarget.getOrAwaitValue()).isEqualTo("Bull")
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isNotEqualTo(true)
    }

    @Test
    fun testIfGameFinishes() {
        viewModel.setToLastTarget()
        viewModel.clickHandler(1)

        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(50)
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }
}