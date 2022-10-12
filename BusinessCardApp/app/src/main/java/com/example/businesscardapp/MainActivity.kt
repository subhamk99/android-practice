package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            .fillMaxWidth()
            .background(Color(0xFF3073042))
    ) {
        ContactLogoNameTitleSection(
            logo = painterResource(id = R.drawable.android_logo),
            name = stringResource(R.string.contact_name),
            title = stringResource(R.string.contact_title)
        )
        ContactInfo(
            phoneNumber = stringResource(R.string.contact_mobile),
            socialMediaHandle = stringResource(R.string.contact_social_media_handle),
            email = stringResource(R.string.contact_email)
        )
    }
}

@Composable
private fun ContactLogoNameTitleSection(
    logo: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(painter = logo, contentDescription = null)
        Text(text = name)
        Text(text = title)
    }
}

@Composable
private fun ContactInfo(
    phoneNumber: String,
    socialMediaHandle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ContactInfoItem(
            icon = painterResource(id = R.drawable.ic_baseline_call_24),
            textData = phoneNumber
        )
        ContactInfoItem(
            icon = painterResource(id = R.drawable.ic_baseline_share_24),
            textData = socialMediaHandle
        )
        ContactInfoItem(
            icon = painterResource(id = R.drawable.ic_baseline_email_24),
            textData = email
        )
    }
}

@Composable
private fun ContactInfoItem(
    icon: Painter,
    textData: String,
    modifier: Modifier = Modifier
) {
    Row() {
        Image(painter = icon, contentDescription = null)
        Text(text = textData)
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