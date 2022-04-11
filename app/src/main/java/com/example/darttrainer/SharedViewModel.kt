package com.example.darttrainer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.darttrainer.models.GameModel
import com.example.darttrainer.models.MatchModel
import com.example.darttrainer.repository.gameList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private val _selectedGame = MutableLiveData<GameModel>()
    val selectedGame: LiveData<GameModel>
        get() = _selectedGame

    fun selectGame(game: String) {
        _selectedGame.value = gameList.find { it.name == game }
        Log.d("navigation", selectedGame.value?.name ?: "null")
    }


    private val _matchSettings = MutableLiveData<MatchModel>()
    val matchSettings: LiveData<MatchModel>
        get() = _matchSettings

    fun getMatchSettings(
        p1Points: Int?,
        legs: Int?,
        sets: Int?,
        p1In: String?,
        p1Out: String?,
        p2Points: Int? = null,
        p2In: String? = null,
        p2Out: String? = null,
    ) {
        _matchSettings.value = MatchModel(
            p1Points,
            legs,
            sets,
            p1In,
            p1Out,
            p2Points,
            p2In,
            p2Out
        )
    }

    private val _hundredDartsTarget = MutableLiveData<String>()
    val hundredDartsTarget: LiveData<String>
        get() = _hundredDartsTarget

    fun setHundredDartsTarget(target: String) {
        _hundredDartsTarget.value = target
    }

    val hundredDartsTargets = arrayOf(
        "20",
        "19",
    )
}