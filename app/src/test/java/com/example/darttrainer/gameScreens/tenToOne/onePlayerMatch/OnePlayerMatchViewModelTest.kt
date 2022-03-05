package com.example.darttrainer.gameScreens.tenToOne.onePlayerMatch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test

class OnePlayerMatchViewModelTest {

    private lateinit var viewModel: OnePlayerMatchViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun hundredPointsScored_clickHandler_returnsHundredPoints() {
        viewModel = OnePlayerMatchViewModel(
            501,
            3,
            2,
            "all",
            "double",
        )
        viewModel._pointsScored.value = "100"
        viewModel.clickHandler()

        assertThat(viewModel.pointsLeft.getOrAwaitValue()).isEqualTo(401)
        assertThat(viewModel.legs.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.sets.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun testLegFinish() {
        viewModel = OnePlayerMatchViewModel(
            501,
            3,
            2,
            "all",
            "double",
        )
        viewModel.setTo170Points()
        viewModel._pointsScored.value = "170"
        viewModel.clickHandler()

        assertThat(viewModel.pointsLeft.getOrAwaitValue()).isEqualTo(501)
        assertThat(viewModel.legs.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.sets.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isFalse()
    }

    @Test
    fun testSetFinish() {
        viewModel = OnePlayerMatchViewModel(
            501,
            3,
            2,
            "all",
            "double",
        )
        viewModel.setTo2Legs()
        viewModel.setTo170Points()
        viewModel._pointsScored.value = "170"
        viewModel.clickHandler()

        assertThat(viewModel.pointsLeft.getOrAwaitValue()).isEqualTo(501)
        assertThat(viewModel.legs.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.sets.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isFalse()
    }

    @Test
    fun testGameFinish() {
        viewModel = OnePlayerMatchViewModel(
            501,
            3,
            2,
            "all",
            "double",
        )
        viewModel.setTo1Set()
        viewModel.setTo2Legs()
        viewModel.setTo170Points()
        viewModel._pointsScored.value = "170"
        viewModel.clickHandler()

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }


}