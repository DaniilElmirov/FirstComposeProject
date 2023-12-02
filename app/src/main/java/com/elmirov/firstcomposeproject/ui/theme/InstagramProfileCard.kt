package com.elmirov.firstcomposeproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elmirov.firstcomposeproject.MainViewModel
import com.elmirov.firstcomposeproject.R

@Composable
fun InstagramProfileCard(viewModel: MainViewModel) {
    val isFollowed by viewModel.isFollowing.observeAsState(false)

    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onBackground),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "Icon",
                )

                UserStatistics(value = "1234", title = "Posts")
                UserStatistics(value = "1", title = "Followers")
                UserStatistics(value = "64M", title = "Following")
            }

            Text(
                text = "Instagram",
                fontSize = 40.sp,
                fontFamily = FontFamily.Cursive,
            )

            Text(
                text = "#YoursToMake",
                fontSize = 16.sp,
            )

            Text(
                text = "www.адрес.com/имя_группы",
                fontSize = 16.sp,
            )

            //При рекомпозиции Card будет перерисовываться, т.к. зависит от стейта
            FollowButton(isFollowed = isFollowed) {
                viewModel.changeFollowingStatus()
            }
        }
    }
}

//State less composable fun. Не хранит внутри себя состояние и не управляет им
@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit,
) {
    Button(
        modifier = Modifier
            .padding(top = 8.dp),
        shape = RoundedCornerShape(percent = 8),
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) {
                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            } else
                MaterialTheme.colorScheme.primary
        ),
    ) {
        val text = if (isFollowed) "Unfollow" else "Follow"
        Text(text = text)
    }
}

@Composable
private fun UserStatistics(
    value: String,
    title: String,
) {
    Column(
        modifier = Modifier
            .height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
        )
    }
}