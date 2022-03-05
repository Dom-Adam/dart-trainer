package com.example.darttrainer.models

class GameModel(
    val name: String,
    val layout: String,
    val categories: Array<String>,
    val data: List<String?>,
    val eventHandler: String
)