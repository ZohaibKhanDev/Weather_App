package com.example.weathers.data.repository

import com.example.weathers.domain.model.Weather.Weather

interface ApiClient{
    suspend fun getWeather(): Weather

}