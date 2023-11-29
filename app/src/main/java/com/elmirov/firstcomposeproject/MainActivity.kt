package com.elmirov.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserInfo(name = "Name", age = 22)
        }
    }
}

@Preview //Работает только с composable-функциями без параметров
@Composable
fun UserInfoPreview() {
    UserInfo("NamePreview", 222)
}

@Composable
fun UserInfo(name: String, age: Int) {
    Column {
        repeat(10) {
            Text(text = "Hello, $name. Your age: $age")
        }
    }
}