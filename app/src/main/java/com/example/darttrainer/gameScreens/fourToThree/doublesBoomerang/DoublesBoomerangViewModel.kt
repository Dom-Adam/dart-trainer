package com.example.darttrainer.gameScreens.fourToThree.doublesBoomerang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class DoublesBoomerangViewModel : ViewModel() {

    private var targets = mutableListOf(
        "1",
        "18",
        "4",
        "13",
        "6",
        "10",
        "15",
        "2",
        "17",
        "3",
        "19",
        "7",
        "16",
        "8",
        "11",
        "14",
        "9",
        "12",
        "5",
        "20",
        "Bull",
    )

    private val index1 = MutableLiveData(0)
    val target1 = Transformations.map(index1) { it?.let { targets[it] } ?: "" }

    private val index2 = MutableLiveData(1)
    val target2 = Transformations.map(index2) { it?.let { targets[it] } ?: "" }

    private val index3 = MutableLiveData(2)
    val target3 = Transformations.map(index3) { it?.let { targets[it] } ?: "" }

    private val _target1Hit = MutableLiveData(false)
    val target1Hit: LiveData<Boolean>
        get() = _target1Hit

    private val _target2Hit = MutableLiveData(false)
    val target2Hit: LiveData<Boolean>
        get() = _target2Hit

    private val _target3Hit = MutableLiveData(false)
    val target3Hit: LiveData<Boolean>
        get() = _target3Hit

    private val _dartsThrown = MutableLiveData(0)
    val dartsThrown: LiveData<Int>
        get() = _dartsThrown

    private val _gameFinished = MutableLiveData(false)
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    fun setToLastTarget() {
        targets = targets.drop(20).toMutableList()
        correctTargets()
    }

    fun setTwoLastTargets() {
        targets = targets.drop(19).toMutableList()
        correctTargets()
    }

    fun correctTargets() {
        if (targets.size == 2) {
            if (target1Hit.value == true) {
                if (target2Hit.value == true) index3.value = null else index3.value = 1
            } else index3.value = 0

        } else if (targets.size == 1) {
            if (target1Hit.value == true) {
                index2.value = null
                index3.value = null
            } else {
                index2.value = 0
                index3.value = 0
            }

            if (target2Hit.value == true) index3.value = null else 0
        }
    }

    fun clickHandler(button: Int) {
        when (button) {
            1 -> {
                _target1Hit.value = (target1Hit.value)?.not()
                correctTargets()
            }
            2 -> {
                _target2Hit.value = (target2Hit.value)?.not()
                correctTargets()
            }
            3 -> {
                _target3Hit.value = target3Hit.value?.not()
            }
            0 -> {
                _dartsThrown.value = _dartsThrown.value?.plus(1)
                index2.value?.let { _dartsThrown.value = _dartsThrown.value?.plus(1) }
                index3.value?.let { _dartsThrown.value = _dartsThrown.value?.plus(1) }

                if (target1Hit.value == true) index1.value?.let { targets.removeAt(it) }
                if (target2Hit.value == true) index2.value?.let { targets.removeAt(it) }
                if (target3Hit.value == true) index3.value?.let { targets.removeAt(it) }

                if (targets.isEmpty()) _gameFinished.value = true

                _target1Hit.value = false
                _target2Hit.value = false
                _target3Hit.value = false
            }
        }
    }
}