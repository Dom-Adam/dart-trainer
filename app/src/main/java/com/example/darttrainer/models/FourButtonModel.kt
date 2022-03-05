package com.example.darttrainer.models

import androidx.lifecycle.LiveData

data class FourButtonModel(
    val label: LiveData<String>,
    val text1: LiveData<String>,
    val text2: LiveData<String>,
    val text3: LiveData<String>,
    val text4: LiveData<String>,
    val click: (Int) -> Unit
)