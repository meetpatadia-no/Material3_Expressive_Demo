package com.example.material3expressive.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavKey
import com.example.material3expressive.navigation.Screen1

class NavigationViewModel: ViewModel() {

    val backstack = mutableStateListOf<NavKey>(Screen1)

}