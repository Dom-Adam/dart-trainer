package com.example.darttrainer.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _navigateToCategory = MutableLiveData<String?>()
    val navigateToCategory: LiveData<String?>
        get() = _navigateToCategory

    fun onNavigateToCategory(item: String) {
        _navigateToCategory.value = item
    }

    fun onNavigateToCategoryComplete() {
        _navigateToCategory.value = null
    }
}