package com.example.darttrainer

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.darttrainer.common.composables.CardListItem
import org.junit.Rule
import org.junit.Test

class HomeComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreenTest() {
        composeTestRule.setContent {
            CardListItem("Scoring") {}
        }

        composeTestRule
            .onNodeWithText("Scoring")
            .performClick()
    }
}