package com.elmirov.firstcomposeproject.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.elmirov.firstcomposeproject.ui.theme.NavigationItem.Favorite
import com.elmirov.firstcomposeproject.ui.theme.NavigationItem.Home
import com.elmirov.firstcomposeproject.ui.theme.NavigationItem.Profile
import kotlinx.coroutines.launch

@Preview
@Composable
fun MainScreen() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Log.d(
        "MainScreen",
        snackbarHostState.currentSnackbarData.toString()
    ) //без remember{} вызывает рекомпозицию
    val scope = rememberCoroutineScope()
    val fabIsVisible = rememberSaveable {
        mutableStateOf(true)
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (fabIsVisible.value) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackbarHostState.showSnackbar(
                                message = "SNACK BAR",
                                actionLabel = "Hide Floating Action Bar(FAB)",
                                duration = SnackbarDuration.Long,
                            )

                            if (action == SnackbarResult.ActionPerformed)
                                fabIsVisible.value = false
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.secondary,
                ) {
                    Icon(Icons.Outlined.Favorite, contentDescription = null)
                }
            }

        },
        bottomBar = {
            NavigationBar {
                val items = listOf(Home, Favorite, Profile)
                val selectedItemPosition = rememberSaveable {
                    mutableStateOf(0)
                }

                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedItemPosition.value,
                        onClick = { selectedItemPosition.value = index },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            indicatorColor = MaterialTheme.colorScheme.primary
                        ),
                    )
                }
            }
        },
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = ""
        )
    }
}