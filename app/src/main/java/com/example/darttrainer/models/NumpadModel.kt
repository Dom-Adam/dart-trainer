package com.example.darttrainer.models

import androidx.lifecycle.LiveData

data class NumpadModel(
    val label1: LiveData<String>?,
    val label2: LiveData<String>,
    val label3: LiveData<String>?,
    val text1: LiveData<String>,
    val text2: LiveData<String>,
    val text3: LiveData<String>,
    val text4: LiveData<String>,
    val text5: LiveData<String>,
    val text6: LiveData<String>,
    val text7: LiveData<String>,
    val text8: LiveData<String>,
    val text9: LiveData<String>,
    val text10: LiveData<String>,
    val click: (Int) -> Unit,
)