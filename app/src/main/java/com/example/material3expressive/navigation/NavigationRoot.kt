package com.example.material3expressive.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.example.material3expressive.ui.screens.Screen1Ui
import com.example.material3expressive.ui.screens.Screen2Ui
import com.example.material3expressive.viewmodel.NavigationViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
data object Screen1 : NavKey

@Serializable
data class Screen2(val itemId: Int) : NavKey

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    viewModel: NavigationViewModel = koinViewModel()
) {

    val backstack = viewModel.backstack

    NavDisplay(
        modifier = modifier,
        backStack = backstack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is Screen1 -> {
                    NavEntry(key = key) { Screen1Ui(onNextClicked = { backstack.add(Screen2(it)) }) }
                }

                is Screen2 -> {
                    NavEntry(key = key) { Screen2Ui(
                        viewModel = koinViewModel {
                            parametersOf(key.itemId)
                        }
                    ) }
                }

                else -> throw RuntimeException("Unknown Screen")
            }
        }
    )

}