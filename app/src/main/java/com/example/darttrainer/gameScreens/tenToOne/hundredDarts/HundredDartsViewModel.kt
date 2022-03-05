package com.example.darttrainer.gameScreens.tenToOne.hundredDarts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HundredDartsViewModel : ViewModel() {

    private val _currentScore = MutableLiveData(0)
    val currentScore: LiveData<Int>
        get() = _currentScore

    private val _dartsLeft = MutableLiveData(100)
    val dartsLeft: LiveData<Int>
        get() = _dartsLeft

    private val _firstSingleSelected = MutableLiveData(false)
    val firstSingleSelected: LiveData<Boolean>
        get() = _firstSingleSelected

    private val _secondSingleSelected = MutableLiveData(false)
    val secondSingleSelected: LiveData<Boolean>
        get() = _secondSingleSelected

    private val _thirdSingleSelected = MutableLiveData(false)
    val thirdSingleSelected: LiveData<Boolean>
        get() = _thirdSingleSelected

    private val _firstDoubleSelected = MutableLiveData(false)
    val firstDoubleSelected: LiveData<Boolean>
        get() = _firstDoubleSelected

    private val _secondDoubleSelected = MutableLiveData(false)
    val secondDoubleSelected: LiveData<Boolean>
        get() = _secondDoubleSelected

    private val _thirdDoubleSelected = MutableLiveData(false)
    val thirdDoubleSelected: LiveData<Boolean>
        get() = _thirdDoubleSelected

    private val _firstTrebleSelected = MutableLiveData(false)
    val firstTrebleSelected: LiveData<Boolean>
        get() = _firstTrebleSelected

    private val _secondTrebleSelected = MutableLiveData(false)
    val secondTrebleSelected: LiveData<Boolean>
        get() = _secondTrebleSelected

    private val _thirdTrebleSelected = MutableLiveData(false)
    val thirdTrebleSelected: LiveData<Boolean>
        get() = _thirdTrebleSelected

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    fun setLastVisit() {
        _dartsLeft.value = 1
    }

    fun clickHandler(button: Int) {
        when (button) {
            1 -> {
                _firstSingleSelected.value = (firstSingleSelected.value)?.not()
                if (firstSingleSelected.value == true) {
                    _firstDoubleSelected.value = false
                    _firstTrebleSelected.value = false
                }
            }
            2 -> {
                _secondSingleSelected.value = (secondSingleSelected.value)?.not()
                if (secondSingleSelected.value == true) {
                    _secondDoubleSelected.value = false
                    _secondTrebleSelected.value = false
                }
            }
            3 -> {
                _thirdSingleSelected.value = (thirdSingleSelected.value)?.not()
                if (thirdSingleSelected.value == true) {
                    _thirdDoubleSelected.value = false
                    _thirdTrebleSelected.value = false
                }
            }
            4 -> {
                _firstDoubleSelected.value = (firstDoubleSelected.value)?.not()
                if (firstDoubleSelected.value == true) {
                    _firstSingleSelected.value = false
                    _firstTrebleSelected.value = false
                }
            }
            5 -> {
                _secondDoubleSelected.value = (secondDoubleSelected.value)?.not()
                if (secondDoubleSelected.value == true) {
                    _secondSingleSelected.value = false
                    _secondTrebleSelected.value = false
                }
            }
            6 -> {
                _thirdDoubleSelected.value = (thirdDoubleSelected.value)?.not()
                if (thirdDoubleSelected.value == true) {
                    _thirdSingleSelected.value = false
                    _thirdTrebleSelected.value = false
                }
            }
            7 -> {
                _firstTrebleSelected.value = (firstTrebleSelected.value)?.not()
                if (firstTrebleSelected.value == true) {
                    _firstSingleSelected.value = false
                    _firstDoubleSelected.value = false
                }
            }
            8 -> {
                _secondTrebleSelected.value = (secondTrebleSelected.value)?.not()
                if (secondTrebleSelected.value == true) {
                    _secondSingleSelected.value = false
                    _secondDoubleSelected.value = false
                }
            }
            9 -> {
                _thirdTrebleSelected.value = (thirdTrebleSelected.value)?.not()
                if (thirdTrebleSelected.value == true) {
                    _thirdSingleSelected.value = false
                    _thirdDoubleSelected.value = false
                }
            }
            0 -> {
                if (firstSingleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(1)
                    _firstSingleSelected.value = false
                } else if (firstDoubleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(2)
                    _firstDoubleSelected.value = false
                } else if (firstTrebleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(3)
                    _firstTrebleSelected.value = false
                }

                if (secondSingleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(1)
                    _secondSingleSelected.value = false
                } else if (secondDoubleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(2)
                    _secondDoubleSelected.value = false
                } else if (secondTrebleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(3)
                    _secondTrebleSelected.value = false
                }

                if (thirdSingleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(1)
                    _thirdSingleSelected.value = false
                } else if (thirdDoubleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(2)
                    _thirdDoubleSelected.value = false
                } else if (thirdTrebleSelected.value == true) {
                    _currentScore.value = _currentScore.value?.plus(3)
                    _thirdTrebleSelected.value = false
                }

                _dartsLeft.value = _dartsLeft.value?.minus(3)
                if (compareValues(dartsLeft.value, 0) < 0) _gameFinished.value = true
            }
        }
    }
}