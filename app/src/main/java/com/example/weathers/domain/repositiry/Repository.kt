package com.example.weathers.domain.repositiry

import com.example.weathers.data.remote.WeatherApiClient
import com.example.weathers.data.repository.ApiClient
import com.example.weathers.domain.model.Weather.Weather


class Repository :ApiClient {
    override suspend fun getWeather(): Weather {
        return WeatherApiClient.getWeather()
    }
}