package com.example.darttrainer.displayGames

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DisplayGamesViewModel : ViewModel() {

    private val _navigateToGame = MutableLiveData<String?>()
    val navigateToGame: LiveData<String?>
        get() = _navigateToGame

    fun onNavigateToScreen(game: String) {
        _navigateToGame.value = game
    }

    fun onNavigateToScreenComplete() {
        _navigateToGame.value = null
    }
}