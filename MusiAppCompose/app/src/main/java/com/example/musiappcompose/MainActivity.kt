package com.example.musiappcompose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import androidx.compose.ui.graphics.painter.Painter
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
    val sliderValue2 = remember { mutableStateOf(25f) }
    val sliderValue = remember { mutableStateOf(70f) }
    val currentImage = remember { mutableStateOf(R.drawable.play_3917707) }
    val imagePainter: Painter = painterResource(id = currentImage.value)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Row(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)

            ) {

                Slider(

                    value = sliderValue2.value,
                    onValueChange = { newValue -> sliderValue.value = newValue },
                    valueRange = 0f..100f,
                    steps = 99,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Black,
                        activeTrackColor = Color.Black,
                        inactiveTrackColor = Color.LightGray,
                    )

                )
            }
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Volume: ${sliderValue.value.toInt()}"
                )
            }

            Row {
                Image(
                    modifier = Modifier
                        .clip(RectangleShape)
                        .padding(top = 100.dp)
                        .background(color = Color.LightGray)
                        .size(400.dp)
                        .border(2.dp, Color.Black)
                        .wrapContentSize(Alignment.Center),
                    painter = painterResource(R.drawable._x1900_000000_80_0_0),
                    contentDescription = null
                )
            }
            Row {
                Text(
                    text = "Mi barrio huele a Widow",
                    modifier = Modifier
                        .padding(top = 25.dp)
                )
            }
            Row {
                Text(
                    text = "Ayax y Prok"
                )
            }
            Row {
                Slider(
                    value = sliderValue.value,
                    onValueChange = { },
                    valueRange = 0f..100f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Black,
                        activeTrackColor = Color.Black,
                        inactiveTrackColor = Color.LightGray,
                    )
                )
            }
            Row {
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .padding(top = 30.dp)
                        .size(40.dp),
                    painter = painterResource(R.drawable.microphone_alt_5528207),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 55.dp),
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
                        .graphicsLayer(rotationZ = 180f),
                    painter = painterResource(R.drawable.forward_3917719),
                    contentDescription = null
                )
                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp) // Ajusta el tamaño de la imagen
                        .clickable {
                            // Cambiar la imagen al hacer clic
                            currentImage.value = if (currentImage.value == R.drawable.play_3917707) {
                                R.drawable.pause_3917542 // Cambia a la imagen de pausa
                            } else {
                                R.drawable.play_3917707 // Cambia a la imagen de play
                            }
                        }
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

@Preview(
    showBackground = true, showSystemUi = true,
    device = "spec:width=412dp,height=915dp,orientation=landscape"
)
@Composable
fun LandscapeScreenComposition() {
    val sliderValue2 = remember { mutableStateOf(25f) }
    val sliderValue = remember { mutableStateOf(70f) }
    val currentImage = remember { mutableStateOf(R.drawable.play_3917707) }
    val imagePainter: Painter = painterResource(id = currentImage.value)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .background(Color.White)
            .padding(end = 40.dp),

        ) {
        Image(
            modifier = Modifier
                .clip(RectangleShape)
                .background(color = Color.White)
                .padding(top = 40.dp, start = 30.dp)
                .size(300.dp)
                .border(2.dp, Color.Black),
            painter = painterResource(R.drawable._x1900_000000_80_0_0),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Ayax y Prok",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 209.dp, top = 100.dp)
                )
                Text(
                    text = "Mi barrio huele a Widow",
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .padding(start = 175.dp)
                        .fillMaxWidth()
                )
            }

            Row() {
                Slider(
                    value = sliderValue2.value,
                    onValueChange = { },
                    valueRange = 0f..100f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Black,
                        activeTrackColor = Color.Black,
                        inactiveTrackColor = Color.LightGray
                    )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .height(16.dp),
                    painter = painterResource(R.drawable.share_3917633),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .graphicsLayer(rotationZ = 180f),
                    painter = painterResource(R.drawable.forward_3917719),
                    contentDescription = null
                )
                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            currentImage.value =
                                if (currentImage.value == R.drawable.play_3917707) {
                                    R.drawable.pause_3917542
                                } else {
                                    R.drawable.play_3917707
                                }
                        }
                )
                Image(
                    modifier = Modifier.size(40.dp),
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
                Image(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .size(40.dp),
                    painter = painterResource(R.drawable.microphone_alt_5528207),
                    contentDescription = null
                )
            }

            Row(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(top = 20.dp)
            ) {
                Slider(
                    value = sliderValue.value,
                    onValueChange = { newValue -> sliderValue.value = newValue },
                    valueRange = 0f..100f,
                    steps = 99,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Black,
                        activeTrackColor = Color.Black,
                        inactiveTrackColor = Color.LightGray
                    )
                )
            }

            Row(
                modifier = Modifier.padding(start = 200.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(text = "Volume: ${sliderValue.value.toInt()}")
            }
        }
    }
}