package com.example.darttrainer.homeScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.darttrainer.common.composables.CardListItem
import com.example.darttrainer.repository.CategoryList

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    LazyColumn {
        items(CategoryList.getCategories.size) { index ->
            CardListItem(category = CategoryList.getCategories[index].name) { category ->
                viewModel.onNavigateToCategory(category)
            }
        }
    }
}