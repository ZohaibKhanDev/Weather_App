package com.example.weathers.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weathers.domain.model.Weather.Current
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

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherData(navController: NavController) {
    var search by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFFFFFFF)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.width(287.dp).height(60.dp), contentAlignment = Alignment.TopCenter){
            TextField(value = search,
                onValueChange = {
                    search = it
                },
                placeholder = {
                    Text(text = "Search")
                },
                modifier = Modifier
                    .fillMaxSize(),
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color(0XFFC4C4C4),
                    unfocusedTextColor = Color(0XFFC4C4C4),
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    focusedPlaceholderColor = Color(0XFFC4C4C4),
                    unfocusedPlaceholderColor = Color(0XFFC4C4C4),
                    focusedLeadingIconColor = Color(0XFFC4C4C4),
                    unfocusedLeadingIconColor = Color(0XFFC4C4C4),
                    focusedTrailingIconColor = Color(0XFFC4C4C4),
                    unfocusedTrailingIconColor = Color(0XFFC4C4C4),
                    containerColor = Color(0XFFFDFCFC)
                ), shape = RoundedCornerShape(15.dp)
            )
        }


    }

}

