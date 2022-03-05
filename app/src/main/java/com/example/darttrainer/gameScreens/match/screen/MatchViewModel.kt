package com.example.darttrainer.gameScreens.match.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.darttrainer.models.MatchModel
import com.example.darttrainer.models.NumpadModel

class MatchViewModel(private val matchSettings: LiveData<MatchModel>) : ViewModel() {

    private val _label = MutableLiveData<String>()
    private val _button1Text = MutableLiveData<String>()
    private val _button2Text = MutableLiveData<String>()
    private val _button3Text = MutableLiveData<String>()
    private val _button4Text = MutableLiveData<String>()
    private val _button5Text = MutableLiveData<String>()
    private val _button6Text = MutableLiveData<String>()
    private val _button7Text = MutableLiveData<String>()
    private val _button8Text = MutableLiveData<String>()
    private val _button9Text = MutableLiveData<String>()
    private val _button10Text = MutableLiveData<String>()

    private val _player1Points = MutableLiveData<Int>()
    val player1Points: LiveData<Int>
        get() = _player1Points

    private val _player1Legs = MutableLiveData<Int>()
    val player1Legs: LiveData<Int>
        get() = _player1Legs

    private val _player1Sets = MutableLiveData<Int>()
    val player1Sets: LiveData<Int>
        get() = _player1Sets

    private val _player2Points = MutableLiveData<Int>()
    val player2Points: LiveData<Int>
        get() = _player2Points

    private val _player2Legs = MutableLiveData<Int>()
    val player2Legs: LiveData<Int>
        get() = _player2Legs

    private val _player2Sets = MutableLiveData<Int>()
    val player2Sets: LiveData<Int>
        get() = _player2Sets

    private val _player1 = MutableLiveData<Boolean>()
    val player1: LiveData<Boolean>
        get() = _player1

    private val _matchFinished = MutableLiveData<Boolean>()
    val matchFinished: LiveData<Boolean>
        get() = _matchFinished


    fun onMatchFinished() {
        _matchFinished.value = true
    }


    val buttonModel = NumpadModel(
        null,
        _label,
        null,
        _button1Text,
        _button2Text,
        _button3Text,
        _button4Text,
        _button5Text,
        _button6Text,
        _button7Text,
        _button8Text,
        _button9Text,
        _button10Text,
        { pointsScored: Int ->

            if (player1.value == true) {
                val remainingPoints = compareValues(player1Points.value, pointsScored)

                if (remainingPoints > 0) {
                    _player1Points.value = (player1Points.value)?.minus(pointsScored)
                } else if (remainingPoints == 0) {

                    matchSettings.value?.p1Points.let { _player1Points.value = it }
                    _player1Legs.value = (player1Points.value)?.plus(1)

                    if (player1Legs.value == matchSettings.value?.legs) {
                        _player1Sets.value = (player1Sets.value)?.plus(1)
                    }

                    if (player1Sets.value == matchSettings.value?.sets) _matchFinished.value = true
                }
            } else {
                val remainingPoints = compareValues(player1Points.value, pointsScored)

                if (remainingPoints > 0) {
                    _player2Points.value = (player2Points.value)?.minus(pointsScored)
                } else if (remainingPoints == 0) {

                    matchSettings.value?.p2Points.let { _player1Points.value = it }
                    _player2Legs.value = (player2Points.value)?.plus(1)

                    if (player2Legs.value == matchSettings.value?.legs) {
                        _player2Sets.value = (player2Sets.value)?.plus(1)
                    }

                    if (player2Sets.value == matchSettings.value?.sets) _matchFinished.value = true
                }
            }
        },
    )


    init {
        _button1Text.value = "1"
        _button2Text.value = "2"
        _button3Text.value = "3"
        _button4Text.value = "4"
        _button5Text.value = "5"
        _button6Text.value = "6"
        _button7Text.value = "7"
        _button8Text.value = "8"
        _button9Text.value = "9"
        _button10Text.value = "Enter"
        matchSettings.value?.p1Points.let { _player1Points.value = it }
        matchSettings.value?.p2Points.let { _player2Points.value = it }
        _player1Legs.value = 0
        _player2Legs.value = 0
        _player1Sets.value = 0
        _player2Sets.value = 0
    }
}