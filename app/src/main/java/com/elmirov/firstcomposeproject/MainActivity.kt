package com.elmirov.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.elmirov.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            FirstComposeProjectTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(MaterialTheme.colorScheme.background)
//                ) {
//                    InstagramProfileCard(viewModel)
//                }
//            }

            LazyColumnTest(viewModel = viewModel)
        }
    }
}

@Composable
private fun LazyColumnTest(
    viewModel: MainViewModel,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Какой-то заголовок",
                )
            }

            items(10) {
                InstagramProfileCard(viewModel = viewModel)
            }

            item {
                Icon(
                    modifier = Modifier.fillMaxWidth(),
                    imageVector = Icons.Outlined.Done,
                    contentDescription = null,
                )
            }

            items(200) {
                InstagramProfileCard(viewModel = viewModel)
            }
        }
    }
}