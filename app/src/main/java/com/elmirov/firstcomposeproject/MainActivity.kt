package com.elmirov.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elmirov.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.elmirov.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FirstComposeProjectTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    InstagramProfileCard()
                }
            }
        }
    }
}

@Preview
@Composable
private fun TextTest() {
    Column {
        Text(
            text = "Hello World",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            )
        )

        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Hello")
                }

                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(" ")
                }

                withStyle(
                    SpanStyle(
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 20.sp
                    )
                ) {
                    append("World!")
                }
            }
        )
    }
}

@Preview
@Composable
private fun ImageTest() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red),
    ) {
        Image(
            //Modifier выполняются в том порядке, в котором указаны
            modifier = Modifier
                .background(Color.Green)
                .padding(all = 24.dp)
                .clip(CircleShape)
                .size(100.dp)
                .background(Color.Yellow)
                .padding(24.dp),
            painter = ColorPainter(Color.Blue),
            contentDescription = "Instagram icon",
        )
    }
}