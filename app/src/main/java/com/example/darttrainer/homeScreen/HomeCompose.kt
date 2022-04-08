package com.example.darttrainer.homeScreen

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeListItem(category: String) {
    Card {
        Text(text = category)
    }
}