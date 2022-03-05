package com.example.darttrainer.gameScreens.fourToThree.doublesBoomerang

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DoublesBoomerangViewModelTest {

    private lateinit var viewModel: DoublesBoomerangViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = DoublesBoomerangViewModel()
    }

    @Test
    fun targetNotHit_clickHandler1_returnsTarget1Hit() {
        viewModel.clickHandler(1)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isTrue()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun target2NotHit_clickHandler2_returnsTarget2Hit() {
        viewModel.clickHandler(2)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isTrue()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun target3NotHit_clickHandler3_returnsTarget3Hit() {
        viewModel.clickHandler(3)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isTrue()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun target1Hit_clickHandler1_returnsTarget1NotHit() {
        viewModel.clickHandler(1)
        viewModel.clickHandler(1)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun target2Hit_clickHandler2_returnsTarget2NotHit() {
        viewModel.clickHandler(2)
        viewModel.clickHandler(2)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun target3Hit_clickHandler3_returnsTarget3NotHit() {
        viewModel.clickHandler(3)
        viewModel.clickHandler(3)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(0)
    }

    @Test
    fun target1Hit_clickHandler0_returnsNextTarget() {
        viewModel.clickHandler(1)
        viewModel.clickHandler(0)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("13")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(3)
    }

    @Test
    fun target2Hit_clickHandler0_returnsNextTarget() {
        viewModel.clickHandler(2)
        viewModel.clickHandler(0)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("4")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("13")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(3)
    }

    @Test
    fun target3Hit_clickHandler0_returnsNextTarget() {
        viewModel.clickHandler(3)
        viewModel.clickHandler(0)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("1")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("18")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("13")
        assertThat(viewModel.target1Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target2Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.target3Hit.getOrAwaitValue()).isFalse()
        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(3)
    }

    @Test
    fun setToLastTwoTargets_target1Hit_returnsTarget2And3IsRemainingFinish() {
        viewModel.setTwoLastTargets()
        viewModel.clickHandler(1)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("20")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("Bull")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("Bull")
    }

    @Test
    fun setToLastTwoTargets_target2Hit_returnsTarget1And3IsRemainingFinish() {
        viewModel.setTwoLastTargets()
        viewModel.clickHandler(2)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("20")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("Bull")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("20")
    }

    @Test
    fun setToLastTwoTargets_target3Hit_returnsTarget1And2StaySame() {
        viewModel.setTwoLastTargets()
        viewModel.clickHandler(3)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("20")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("Bull")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("20")
    }

    @Test
    fun setToLastTwoTargets_target1And2Hit_returnsTarget3IsNull() {
        viewModel.setTwoLastTargets()
        viewModel.clickHandler(1)
        viewModel.clickHandler(2)

        assertThat(viewModel.target1.getOrAwaitValue()).isEqualTo("20")
        assertThat(viewModel.target2.getOrAwaitValue()).isEqualTo("Bull")
        assertThat(viewModel.target3.getOrAwaitValue()).isEqualTo("")
    }

    @Test
    fun testIfFirstDartGameFinishAddsOneDart() {
        viewModel.setToLastTarget()
        viewModel.clickHandler(1)
        viewModel.clickHandler(0)

        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(1)
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }

    @Test
    fun testIfSecondDartGameFinishAddsTwoDarts() {
        viewModel.setToLastTarget()
        viewModel.clickHandler(2)
        viewModel.clickHandler(0)

        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(2)
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }

    @Test
    fun testIfThirdDartGameFinishAddsThreeDarts() {
        viewModel.setToLastTarget()
        viewModel.clickHandler(3)
        viewModel.clickHandler(0)

        assertThat(viewModel.dartsThrown.getOrAwaitValue()).isEqualTo(3)
        assertThat(viewModel.gameFinished.getOrAwaitValue()).isTrue()
    }
}