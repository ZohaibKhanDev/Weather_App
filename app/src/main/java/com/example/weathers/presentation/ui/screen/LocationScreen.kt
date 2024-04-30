package com.example.weathers.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weathers.R
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
    val scrollState = rememberScrollState()
    var darkMode by remember {
        mutableStateOf(false)
    }
    Icon(imageVector = Icons.Outlined.DarkMode, contentDescription = "")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0XFFFFFFFF)),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = search,
                onValueChange = {
                    search = it
                },
                placeholder = {
                    Text(text = "Search location", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier
                    .padding(start = 60.dp)
                    .width(287.dp)
                    .height(50.dp),
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
                ),
                shape = RoundedCornerShape(30.dp),
                trailingIcon = {
                    Icon(imageVector = Icons.Outlined.Search, contentDescription = "")
                },
                textStyle = TextStyle(
                    fontSize = 14.sp, fontWeight = FontWeight.Bold
                )
            )
            if (darkMode){
                Icon(
                    imageVector = Icons.Default.DarkMode,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 17.dp)
                        .size(27.dp).clickable { darkMode=!darkMode }, tint = Color(0XFFC4C4C4)
                )
            }
            else{
                Icon(
                    imageVector = Icons.Outlined.DarkMode,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 17.dp)
                        .size(27.dp).clickable { darkMode=!darkMode }, tint = Color(0XFFC4C4C4)
                )
            }

        }




        Image(
            painter = painterResource(id = R.drawable.weather),
            contentDescription = "",
            modifier = Modifier.size(280.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Mahmood Kot", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = R.drawable.go),
                contentDescription = "",
                modifier = Modifier
                    .width(21.dp)
                    .height(21.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(text = "80º", fontSize = 60.sp, fontWeight = FontWeight.Medium)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(164.dp),
            colors = CardDefaults.cardColors(Color(0XFFFDFCFC)),
            shape = RoundedCornerShape(11.dp),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {


            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.weather),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .size(130.dp)
                        .align(Alignment.CenterEnd)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 14.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = "",
                            tint = Color(0XFFFFCC4D)
                        )
                        Spacer(modifier = Modifier.width(9.dp))
                        Text(
                            text = "WARNING",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = Color(0XFFFFCC4D)
                        )
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Row(

                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(50.dp)
                    ) {
                        Text(
                            text = "% RAIN",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0XFFC4C4C4)
                        )
                        Text(
                            text = "EXP. TIME",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0XFFC4C4C4)
                        )


                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier.padding(start = 5.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(74.dp)
                    ) {
                        Text(
                            text = "58%",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0XFF9A9A9A)
                        )
                        Text(
                            text = "02:00%",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0XFF9A9A9A)
                        )


                    }



                    Spacer(modifier = Modifier.height(28.dp))
                    Text(
                        text = "Expecting Rainfall",
                        color = Color(0XFFFFD600),
                        modifier = Modifier.align(
                            Alignment.Start
                        )
                    )


                }
            }


        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(16.dp),
            colors = CardDefaults.cardColors(Color(0XFFFDFCFC)),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 5.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "TIME", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Text(text = "UV", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Text(text = "% RAIN", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Text(text = "AQ", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "11:25 AM", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Text(text = "4", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Text(text = "58%", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Text(text = "22", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 30.dp)
                .height(232.dp), colors = CardDefaults.cardColors(Color(0XFFFDFCFC))
        ) {

            Text(
                text = "SUNRISE & SUNSET",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0XFFC4C4C4),
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .padding(start = 50.dp)
                    .width(290.dp)
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.component_3),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "Length of day:",
                    color = Color(0XFF9A9A9A),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(text = "13H 12M", fontSize = 13.sp, fontWeight = FontWeight.Medium)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "Remaining daylight",
                    color = Color(0XFF9A9A9A),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(text = "9H 22M", fontSize = 13.sp, fontWeight = FontWeight.Medium)
            }
        }

    }
}





