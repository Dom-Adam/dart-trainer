package com.example.darttrainer.repository

import com.example.darttrainer.models.CategoryModel

object CategoryList {
    val getCategories = arrayOf(
        CategoryModel("Scoring"),
        CategoryModel("Finishing"),
        CategoryModel("Daily Routine"),
        CategoryModel("-01"),
        CategoryModel("Settings")
    )
}