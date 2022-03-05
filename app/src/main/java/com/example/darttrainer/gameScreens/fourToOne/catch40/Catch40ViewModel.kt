package com.example.darttrainer.gameScreens.fourToOne.catch40

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Catch40ViewModel : ViewModel() {

    private val _currentTarget = MutableLiveData(61)
    val currentTarget: LiveData<Int>
        get() = _currentTarget

    private val _currentScore = MutableLiveData(0)
    val currentScore: LiveData<Int>
        get() = _currentScore

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    fun setLastTarget() {
        _currentTarget.value = 100
    }

    fun onGameFinishedComplete() {
        _gameFinished.value = false
    }

    fun clickHandler(button: Int) {
        if (compareValues(currentTarget.value, 100) >= 0) {
            _gameFinished.value = true
        } else {
            _currentScore.value = (currentScore.value)?.plus(button)
            _currentTarget.value = (currentTarget.value)?.plus(1)
            Log.d("click", "${currentTarget.value}")
        }
    }
}