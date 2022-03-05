package com.example.darttrainer.gameScreens.match.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.darttrainer.models.MatchModel

class MatchViewModelFactory(private val matchSettings: LiveData<MatchModel>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchViewModel::class.java)) {
            return MatchViewModel(matchSettings) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}