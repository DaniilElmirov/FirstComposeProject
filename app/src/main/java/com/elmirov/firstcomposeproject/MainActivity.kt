package com.elmirov.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTest()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun ScaffoldTest() {
    ModalNavigationDrawer(
        drawerContent = {
            Column {
                Text(text = "Первый пункт")
                Text(text = "Второй пункт")
                Text(text = "Третий пункт")
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "TopAppBar TITLE")
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = null,
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),
                )
            },

            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        },
                        label = {
                            Text(text = "Favorite")
                        },
                    )

                    NavigationBarItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(Icons.Outlined.Edit, contentDescription = null)
                        },
                        label = {
                            Text(text = "Edit")
                        },
                    )

                    NavigationBarItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(Icons.Outlined.Delete, contentDescription = null)
                        },
                        label = {
                            Text(text = "Delete")
                        },
                    )
                }
            }
        ) {
            Text(
                modifier = Modifier.padding(it),
                text = "Scaffold content",
            )
        }
    }
}

@Composable
private fun Test() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Example1()
            Example2()
            //Example3()
        }
    }
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = {}) {
        Text(text = "Hello World")
    }
}

@Composable
private fun Example2() {
    TextField(
        value = "Value",
        onValueChange = {},
        label = { Text(text = "Label") }
    )
}

@Composable
private fun Example3() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Yes"
            )
        },
        title = {
            Text(
                text = "Are you sure?"
            )
        },
        text = {
            Text(text = "Do you want to delete this file?")
        },
        dismissButton = {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "No"
            )
        }
    )
}