package com.example.darttrainer.gameScreens.fourToOne.DoublesArroundTheWorld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class DoublesArroundTheWorldViewModel : ViewModel() {

    private val targets = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "Bull",
    )

    private val _currentScore = MutableLiveData(0)
    val currentScore: LiveData<Int>
        get() = _currentScore

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    private val index = MutableLiveData(0)
    val currentTarget = Transformations.map(index) { targets[it] }

    private var currentTargetValue = null

    fun setToLastTarget() {
        index.value = targets.lastIndex
    }

    fun clickHandler(button: Int) {
        if (compareValues(index.value, targets.lastIndex) >= 0) {
            _gameFinished.value = true
        } else {
            _currentScore.value = (currentScore.value)?.plus(button)
            index.value = (index.value)?.plus(1)
        }
    }
}