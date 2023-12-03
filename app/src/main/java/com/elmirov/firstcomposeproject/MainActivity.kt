package com.elmirov.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elmirov.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.elmirov.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FirstComposeProjectTheme {
                LazyColumnTest(viewModel = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LazyColumnTest(
    viewModel: MainViewModel,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val models = viewModel.models.observeAsState(listOf())

        LazyColumn {
            items(
                models.value,
                key = { it.id } //4.8
            ) { model ->
                val dismissState = rememberDismissState()

                if (dismissState.isDismissed(DismissDirection.EndToStart))
                    viewModel.delete(model)
                SwipeToDismiss(
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .background(Color.Red.copy(alpha = 0.5f))
                                .fillMaxSize(),
                            contentAlignment = Alignment.CenterEnd,
                        ) {
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = "Delete Item",
                                color = Color.White,
                                fontSize = 24.sp,
                            )
                        }
                    },
                    dismissContent = {
                        InstagramProfileCard(
                            model = model,
                            onFollowButtonClickListener = {
                                viewModel.changeFollowingStatus(it)
                            },
                        )
                    },
                )
            }
        }
    }
}