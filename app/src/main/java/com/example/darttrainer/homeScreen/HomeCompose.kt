package com.example.darttrainer.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.darttrainer.R
import com.example.darttrainer.repository.CategoryList

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    LazyColumn {
        items(CategoryList.getCategories.size) { index ->
            HomeListItem(category = CategoryList.getCategories[index].name) { category ->
                viewModel.onNavigateToCategory(category)
            }
        }
    }
}

@Composable
fun HomeListItem(category: String, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp)
            .clickable { onClick(category) },
        backgroundColor = colorResource(id = R.color.button_blue),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = category,
            modifier = Modifier.wrapContentSize(align = Alignment.Center),
            color = colorResource(
                id = R.color.white
            ),
            fontSize = 40.sp
        )
    }
}