package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

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

class ListItemModel(icon: ImageVector, iconDescription: String, textData: String) {
    var icon: ImageVector;
    var iconDescription: String;
    var textData: String;

    init {
        this.icon = icon;
        this.iconDescription = iconDescription;
        this.textData = textData;
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFF073042))
            .padding(24.dp),

        ) {
        ContactLogoSection(
            logoId = R.drawable.android_logo,
            logoDescription = "android_logo",
            name = "Subham Khadanga",
            title = "Software Developer"
        )
        val listItems: MutableList<ListItemModel> = mutableListOf();
        listItems.add(
            ListItemModel(
                Icons.Default.Call,
                "call", "+91 7978637650"
            )
        )
        listItems.add(
            ListItemModel(
                Icons.Default.Share,
                "instagram", "@subhamk_"
            )
        )
        listItems.add(
            ListItemModel(
                Icons.Default.Email,
                "email", "subhamkhadanga97@gmail.com"
            )
        )
        ContactInfo(listItems)
    }
}

@Composable
fun ColumnScope.ContactLogoSection(
    logoId: Int,
    logoDescription: String,
    name: String,
    title: String
) {
    Column(
        modifier = Modifier.weight(3f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var image = painterResource(id = logoId)
        Image(
            painter = image,
            contentDescription = logoDescription,
            modifier = Modifier
                .size(width = 150.dp, height = 150.dp)
                .padding(vertical = 8.dp)
        )
        Text(
            text = name,
            color = Color.White,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            lineHeight = 36.sp,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
        Text(
            text = title, color = Color(0xFF3ddc84), fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun ColumnScope.ContactInfo(
    list: List<ListItemModel>
) {
    LazyColumn(
        modifier = Modifier
            .weight(1f)
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        items(list) { item: ListItemModel ->
            ListItem(
                icon = item.icon,
                iconDescription = item.iconDescription,
                textData = item.textData
            )
        }
    }
}

@Composable
fun ListItem(
    icon: ImageVector,
    iconDescription: String,
    textData: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Icon(
            icon, iconDescription, tint = Color(0xFF3ddc84),
            modifier = Modifier.weight(2f)
        )
        Text(
            text = textData, color = Color.White, fontSize = 15.sp,
            modifier = Modifier.weight(4f)
        )
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