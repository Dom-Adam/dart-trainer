package com.example.darttrainer

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.darttrainer.homeScreen.HomeListItem
import org.junit.Rule
import org.junit.Test

class HomeComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeListItemTest() {
        composeTestRule.setContent {
            HomeListItem("Scoring")
        }

        composeTestRule
            .onNodeWithText("Scoring")
            .assertIsDisplayed()
    }
}