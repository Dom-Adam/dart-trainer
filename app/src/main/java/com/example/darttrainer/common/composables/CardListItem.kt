package com.example.darttrainer.common.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.darttrainer.R

@Composable
fun CardListItem(category: String, onClick: (String) -> Unit) {
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