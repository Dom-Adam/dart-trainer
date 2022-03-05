package com.example.darttrainer.gameScreens.tenToOne.onePlayerMatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnePlayerMatchViewModel(
    private val pointsPerLeg: Int,
    private val legsPerSet: Int,
    private val setsToEnd: Int,
    private val opening: String,
    private val closing: String,
) : ViewModel() {

    private val _pointsLeft = MutableLiveData(pointsPerLeg)
    val pointsLeft: LiveData<Int>
        get() = _pointsLeft

    private val _legs = MutableLiveData(legsPerSet)
    val legs: LiveData<Int>
        get() = _legs

    private val _sets = MutableLiveData(setsToEnd)
    val sets: LiveData<Int>
        get() = _sets

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    val _pointsScored = MutableLiveData<String>()
    val pointsScored: Int?
        get() = _pointsScored.value?.toInt()

    fun setTo170Points() {
        _pointsLeft.value = 170
    }

    fun setTo2Legs() {
        _legs.value = 2
    }

    fun setTo1Set() {
        _sets.value = 1
    }

    fun clickHandler() {
        if (
            compareValues(pointsScored, 180) > 0
            || pointsScored == 179
            || pointsScored == 178
            || pointsScored == 176
            || pointsScored == 175
            || pointsScored == 173
            || pointsScored == 172
            || pointsScored == 169
            || pointsScored == 166
        ) {
            throw IllegalArgumentException("This score is not valid.")
        } else {

        }
    }
}