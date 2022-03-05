package com.example.darttrainer.gameScreens.fourToOne.fourHundredAndTwenty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class FourHundredAndTwentyViewModel : ViewModel() {

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

    private val index = MutableLiveData(0)

    private val _currentScore = MutableLiveData(0)
    val currentScore: LiveData<Int>
        get() = _currentScore

    val currentTarget = Transformations.map(index) { targets[it] }

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    private var currentTargetValue = 2

    fun onGameFinishedComplete() {
        _gameFinished.value = false
    }

    fun setToLastTarget() {
        index.value = targets.lastIndex
    }

    fun clickHandler(button: Int) {
        _currentScore.value = (currentScore.value)?.plus(currentTargetValue * button)
        if (compareValues(index.value, targets.lastIndex) >= 0) {
            _gameFinished.value = true
        } else {
            index.value = (index.value)?.plus(1)

            if (currentTarget.value == "Bull") currentTargetValue = 50
            else currentTargetValue += 2
        }
    }
}