package com.example.darttrainer.homeScreen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.darttrainer.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        homeViewModel = HomeViewModel()
    }

    @Test
    fun onNavigateToCategory() {
        homeViewModel.onNavigateToCategory("some string")

        val value = homeViewModel.navigateToCategory.getOrAwaitValue()

        assertThat(value).isEqualTo("some string")
    }

    @Test
    fun onNavigateToCategoryComplete() {
        homeViewModel.onNavigateToCategory("some string")
        var value = homeViewModel.navigateToCategory.getOrAwaitValue()
        assertThat(value).isNotNull()

        homeViewModel.onNavigateToCategoryComplete()
        value = homeViewModel.navigateToCategory.getOrAwaitValue()

        assertThat(value).isNull()
    }
}