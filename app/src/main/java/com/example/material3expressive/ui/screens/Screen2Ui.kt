package com.example.material3expressive.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.material3expressive.viewmodel.Screen2ViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Screen2Ui(
    modifier: Modifier = Modifier,
    viewModel: Screen2ViewModel = koinViewModel()
) {
    val itemState by viewModel.itemState.collectAsState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = itemState.itemTitle)
            Text(text = itemState.itemDescription)
        }
    }
}