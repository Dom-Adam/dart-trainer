package com.example.darttrainer.displayGames

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DisplayGamesViewModel @Inject constructor() : ViewModel() {

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