package com.example.material3expressive.di

import com.example.material3expressive.viewmodel.NavigationViewModel
import com.example.material3expressive.viewmodel.Screen2ViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { NavigationViewModel() }
    viewModel { (itemId: Int) -> Screen2ViewModel(itemId) }
}