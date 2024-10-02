package com.example.musiappcompose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musiappcompose.ui.theme.MusiAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusiAppComposeTheme {
                GreetingPreview(
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_8_pro")
@Composable
fun GreetingPreview() {
    MusiAppComposeTheme {
        rememberSaveable { mutableStateOf("") }
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                LandscapeScreenComposition()
            }

            else -> Inicio()
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun Inicio() {
    val sliderValue = remember { mutableStateOf(25f) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row (
                modifier = Modifier
               .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){

                Slider(
                    value = sliderValue.value,
                    onValueChange = { newValue -> sliderValue.value = newValue },
                    valueRange = 0f..100f,
                    steps = 99

                )
            }
            Row (
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Volume: ${sliderValue.value.toInt()}")
            }
            Row {
                Image(
                    modifier = Modifier
                        .clip(RectangleShape)
                        .background(color = Color.LightGray)
                        .size(400.dp)
                        .wrapContentSize(Alignment.Center),
                    painter = painterResource(R.drawable._x1900_000000_80_0_0),
                    contentDescription = null
                )
            }
            Row {
                Text(
                    text = "Mi barrio huele a Widow",
                    modifier = Modifier
                )
            }
            Row {
                Text(
                    text = "Ayax y Prok",
                    modifier = Modifier
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            )

            {
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .size(40.dp)
                        .height(16.dp),
                    painter = painterResource(R.drawable.share_3917633),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .size(40.dp)
                        .graphicsLayer(rotationZ = 180f)
                        ,
                    painter = painterResource(R.drawable.forward_3917719),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .size(40.dp)
                        .height(16.dp),
                    painter = painterResource(R.drawable.caret_circle_right_7487177),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .size(40.dp),
                    painter = painterResource(R.drawable.forward_3917719),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .size(40.dp)
                        .height(16.dp),
                    painter = painterResource(R.drawable.list_check_3914414),
                    contentDescription = null
                )


            }
        }
    }
}

@Composable
fun LandscapeScreenComposition() {

}
