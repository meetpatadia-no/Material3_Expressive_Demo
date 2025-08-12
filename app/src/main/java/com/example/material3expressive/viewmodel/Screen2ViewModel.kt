package com.example.material3expressive.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavKey
import com.example.material3expressive.model.dummyItems
import com.example.material3expressive.navigation.Screen1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class Screen2ViewModel(private val itemId: Int) : ViewModel() {

    private val _itemState = MutableStateFlow(dummyItems.first { it.itemId == itemId })
    val itemState = _itemState.asStateFlow()

}
