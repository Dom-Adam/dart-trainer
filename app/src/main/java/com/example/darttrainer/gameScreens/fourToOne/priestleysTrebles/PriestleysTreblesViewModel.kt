package com.example.darttrainer.gameScreens.fourToOne.priestleysTrebles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PriestleysTreblesViewModel : ViewModel() {

    private val _currentTarget = MutableLiveData(10)
    val currentTarget: LiveData<Int>
        get() = _currentTarget

    private val _pointsScored = MutableLiveData(0)
    val pointsScored: LiveData<Int>
        get() = _pointsScored

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    fun setLastTarget() {
        _currentTarget.value = 20
    }

    fun clickHandler(button: Int) {
        if (compareValues(currentTarget.value, 20) >= 0) {
            _gameFinished.value = true
        } else {
            _pointsScored.value = (pointsScored.value)?.plus(button)
            _currentTarget.value = (currentTarget.value)?.plus(1)
        }
    }
}