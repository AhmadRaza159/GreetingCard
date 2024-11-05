package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(Modifier.fillMaxSize().background(Color(0xFFD2E8D4)))
//                    InfoScreen()
//                    TaskDone(stringResource(R.string.all_task_completed), stringResource(R.string.nice_work))
//                    MainArticle(stringResource(R.string.title), stringResource(R.string.headline), stringResource(R.string.summary))
//                    GreetingImage(stringResource(R.string.happy_birthday_ahmad),
//                        stringResource(R.string.from_raza))
                }

            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier=Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        BusinessLogo(
            modifier = Modifier
                .align(Alignment.Center)
        )
        BusinessContactInfo(
            stringResource(R.string.b_phone),stringResource(R.string.b_mail), stringResource(R.string.b_share),
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BusinessContactInfo(phoneNum:String, email:String, username:String, modifier: Modifier=Modifier){
    val imgPhone= painterResource(R.drawable.ic_call)
    val imgShare= painterResource(R.drawable.ic_share)
    val imgEmail= painterResource(R.drawable.ic_email)

    Column(modifier=modifier.width(240.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start) {
        BusinessContactItem(imgPhone, phoneNum)
        BusinessContactItem(imgShare, username)
        BusinessContactItem(imgEmail, email)
        Spacer(modifier.height(30.dp))
    }

}

@Composable
fun BusinessContactItem(icon: Painter, text:String, modifier: Modifier=Modifier){
    Row(modifier=modifier.padding(0.dp, 6.dp)) {
        Image(
            painter = icon,
            contentDescription = null,
            Modifier.width(20.dp).height(20.dp)
        )
        Text(
            text=text,
            color = Color.Black,
            modifier=modifier.padding(20.dp,0.dp)
        )
    }
}

@Composable
fun BusinessLogo(modifier: Modifier=Modifier){
    Column(modifier = modifier.wrapContentSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        val logo= painterResource(R.drawable.android_logo)
        Image(
            painter = logo,
            contentDescription = null,
            Modifier.width(124.dp).background(Color(0xFF073042)).padding(10.dp)
        )
        Text(
            text = stringResource(R.string.b_name),
            fontSize = 48.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            lineHeight = 48.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(0.dp, 16.dp)
        )
        Text(
            text = stringResource(R.string.b_title),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006C37)
        )
    }
}

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = modifier.fillMaxHeight(0.5f)) {
            InfoSheet(
                stringResource(R.string.s1_title),
                stringResource(R.string.s1_details),
                modifier.fillMaxWidth(0.5f).background(Color(0xFFEADDFF))
            )
            InfoSheet(
                stringResource(R.string.s2_title),
                stringResource(R.string.s2_details),
                modifier.background(Color(0xFFD0BCFF))
            )
        }
        Row(modifier = modifier) {
            InfoSheet(
                stringResource(R.string.s3_title),
                stringResource(R.string.s3_details),
                modifier.fillMaxWidth(0.5f).background(Color(0xFFB69DF8))
            )
            InfoSheet(
                stringResource(R.string.s4_title),
                stringResource(R.string.s4_details),
                modifier.background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun InfoSheet(title: String, details: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
        )
        Text(
            text = details,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskDone(title: String, details: String, modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = img,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp)
        )
        Text(
            text = details,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun MainArticle(title: String, headline: String, summary: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ArticleImage()
        ArticleText(title, headline, summary)
    }
}

@Composable
fun ArticleImage(modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = img,
        contentDescription = null,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun ArticleText(title: String, headline: String, summary: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = headline,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = summary,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(8.dp)
        )
    }

}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true, name = "AhmadPreview")
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        BusinessCard(Modifier.fillMaxSize().background(Color(0xFFD2E8D4)))
//        InfoScreen()
//        TaskDone(stringResource(R.string.all_task_completed), stringResource(R.string.nice_work))
//        MainArticle(stringResource(R.string.title), stringResource(R.string.headline), stringResource(R.string.summary))
//        GreetingImage(stringResource(R.string.happy_birthday_ahmad),
//            stringResource(R.string.from_raza))
    }
}