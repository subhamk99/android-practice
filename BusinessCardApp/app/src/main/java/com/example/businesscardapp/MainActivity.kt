package com.example.businesscardapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFF073042))
            .padding(24.dp),

        ) {
        Column(
            modifier = Modifier.weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = "android_logo",
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Subham Khadanga",
                color = Color.White,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Software Developer", color = Color(0xFF3ddc84), fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Column(
            modifier = Modifier.weight(1f).padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Icon(
                    Icons.Default.Call, "call", tint = Color(0xFF3ddc84),
                    modifier = Modifier.weight(2f)
                )
                Text(
                    text = "+91 7978637650", color = Color.White, fontSize = 15.sp,
                    modifier = Modifier.weight(4f)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Icon(
                    Icons.Default.Share, "social_media_handle", tint = Color(0xFF3ddc84),
                    modifier = Modifier.weight(2f)
                )
                Text(
                    text = "@subhamk", color = Color.White, fontSize = 15.sp,
                    modifier = Modifier.weight(4f)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Icon(
                    Icons.Default.Email, "email", tint = Color(0xFF3ddc84),
                    modifier = Modifier.weight(2f)
                )
                Text(
                    text = "subhamkhadanga97@gmail.com", color = Color.White, fontSize = 15.sp,
                    modifier = Modifier.weight(4f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        Surface {
            BusinessCardApp()
        }
    }
}