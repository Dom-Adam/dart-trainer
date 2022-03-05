package com.example.darttrainer.models

data class ViewModelModel(
    val update: (Int) -> Unit,
    val init: () -> Unit
)