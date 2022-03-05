package com.example.darttrainer.gameScreens.tenToOne.hundredDarts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HundredDartsViewModelTest {

    private lateinit var viewModel: HundredDartsViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = HundredDartsViewModel()
    }

    @Test
    fun nothingHit_clickHandler1_returnsFirstSingle() {
        viewModel.clickHandler(1)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler2_returnsSecondSingle() {
        viewModel.clickHandler(2)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler3_returnsThirdSingle() {
        viewModel.clickHandler(3)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler4_returnsFirstDouble() {
        viewModel.clickHandler(4)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler5_returnsSecondDouble() {
        viewModel.clickHandler(5)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler6_returnsThirdDouble() {
        viewModel.clickHandler(6)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler7_returnsFirstTreble() {
        viewModel.clickHandler(7)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler8_returnsSecondTreble() {
        viewModel.clickHandler(8)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun nothingHit_clickHandler9_returnsThirdTreble() {
        viewModel.clickHandler(9)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isTrue()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button1Hit_clickHandler1_returnsNothingHit() {
        viewModel.clickHandler(1)
        viewModel.clickHandler(1)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button2Hit_clickHandler2_returnsNothingHit() {
        viewModel.clickHandler(2)
        viewModel.clickHandler(2)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button3Hit_clickHandler3_returnsNothingHit() {
        viewModel.clickHandler(3)
        viewModel.clickHandler(3)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button4Hit_clickHandler4_returnsNothingHit() {
        viewModel.clickHandler(4)
        viewModel.clickHandler(4)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button5Hit_clickHandler5_returnsNothingHit() {
        viewModel.clickHandler(5)
        viewModel.clickHandler(5)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button6Hit_clickHandler6_returnsNothingHit() {
        viewModel.clickHandler(6)
        viewModel.clickHandler(6)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button7Hit_clickHandler7_returnsNothingHit() {
        viewModel.clickHandler(7)
        viewModel.clickHandler(7)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button8Hit_clickHandler8_returnsNothingHit() {
        viewModel.clickHandler(8)
        viewModel.clickHandler(8)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button9Hit_clickHandler9_returnsNothingHit() {
        viewModel.clickHandler(9)
        viewModel.clickHandler(9)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(0)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(100)
    }

    @Test
    fun button1Hit_clickHandler0_returns1PointNextVisit() {
        viewModel.clickHandler(1)
        viewModel.clickHandler(0)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(97)
    }

    @Test
    fun button4Hit_clickHandler0_returns4PointNextVisit() {
        viewModel.clickHandler(4)
        viewModel.clickHandler(0)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(2)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(97)
    }

    @Test
    fun button7Hit_clickHandler0_returns7PointNextVisit() {
        viewModel.clickHandler(7)
        viewModel.clickHandler(0)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.thirdTrebleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.currentScore.getOrAwaitValue()).isEqualTo(3)
        assertThat(viewModel.dartsLeft.getOrAwaitValue()).isEqualTo(97)
    }

    @Test
    fun testIfFirstDoubleUnchecksFirstSingle() {
        viewModel.clickHandler(1)
        viewModel.clickHandler(4)
        viewModel.clickHandler(7)

        assertThat(viewModel.firstSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstDoubleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.firstTrebleSelected.getOrAwaitValue()).isTrue()
    }

    @Test
    fun testIfFirstDartGroupSelectsOnlyOneButton() {
        viewModel.clickHandler(2)
        viewModel.clickHandler(5)

        assertThat(viewModel.secondSingleSelected.getOrAwaitValue()).isFalse()
        assertThat(viewModel.secondDoubleSelected.getOrAwaitValue()).isTrue()
    }

    @Test
    fun checkIfLastVisitNotSetGameFinished() {
        viewModel.setLastVisit()

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isFalse()
    }

    @Test
    fun testIfGameFinishes() {
        viewModel.setLastVisit()
        viewModel.clickHandler(0)

        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }
}