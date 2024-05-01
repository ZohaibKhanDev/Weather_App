package com.example.weathers.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weathers.R
import com.example.weathers.domain.model.Weather.Weather
import com.example.weathers.domain.usecase.ResultState
import com.example.weathers.presentation.viewModel.MainViewModel
import org.koin.compose.koinInject

@Composable
fun LocationScreen(navController: NavController) {

    val viewModel: MainViewModel = koinInject()
    var weatherData by remember {
        mutableStateOf<Weather?>(null)
    }
    var isWeather by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = isWeather) {
        viewModel.getAllWeather()
    }
    val state by viewModel.allWeather.collectAsState()
    when (state) {
        is ResultState.Error -> {
            isWeather = false
            val error = (state as ResultState.Error).error
            Text(text = error.toString())
        }

        is ResultState.Loading -> {
            isWeather = true

        }

        is ResultState.Success -> {
            isWeather = false
            val success = (state as ResultState.Success).response
            weatherData = success
        }
    }


    if (isWeather) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    weatherData?.let {
        LocationData(weather = it, navController = navController)
    }

}


@Composable
fun LocationData(weather: Weather, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${weather.location?.name}",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )


        Text(
            text = "${weather.current?.tempC}º",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50.dp),
            colors = CardDefaults.cardColors(
                Color(0XFFfafafa)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.mahmood_kot),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds, modifier = Modifier.size(150.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Name:")
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "${weather.location?.name}")

                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "region:")
                    Spacer(modifier = Modifier.width(7.dp))

                    Text(text = "${weather.location?.region}")

                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "country:")
                    Spacer(modifier = Modifier.width(7.dp))

                    Text(text = "${weather.location?.country}")

                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "lat:")
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "${weather.location?.lat}")

                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "lon:")
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "${weather.location?.lon}")

                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "tz_id:")
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "${weather.location?.tzId}")

                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "localtime_epoch:")
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "${weather.location?.localtimeEpoch}")

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "localtime:")
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(text = "${weather.location?.localtime}")

                }



                Text(text = "History", fontSize = 30.sp, fontWeight = FontWeight.Bold)

                Text(
                    text = "Mehmood Kot was established by Mehmood Gujjar, who was the ruler of Dera Ghazi Khan in the 17th century and he built a fort here which he named after himself. The Lal Pir Power is in Mehmood Kot and produces 362 MW of electricity",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(
                        start = 14.dp, end = 14.dp, bottom =
                        35.dp, top = 14.dp
                    )
                )
            }
        }
    }

}