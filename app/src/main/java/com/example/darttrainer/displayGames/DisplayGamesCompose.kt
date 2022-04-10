package com.example.darttrainer.displayGames

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.darttrainer.SharedViewModel
import com.example.darttrainer.common.composables.CardListItem
import com.example.darttrainer.repository.gameList

@Composable
fun DisplayGamesComposable(
    category: String,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    LazyColumn {
        items(gameList.filter { category in it.categories }.size) { index ->
            CardListItem(category = gameList[index].name) { game ->
                sharedViewModel.selectGame(game)
            }
        }
    }
}