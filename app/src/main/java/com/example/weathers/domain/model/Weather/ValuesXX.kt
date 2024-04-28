package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValuesXX(
    @SerialName("cloudBase")
    val cloudBase: Double,
    @SerialName("cloudCeiling")
    val cloudCeiling: Double,
    @SerialName("cloudCover")
    val cloudCover: Double,
    @SerialName("dewPoint")
    val dewPoint: Double,
    @SerialName("freezingRainIntensity")
    val freezingRainIntensity: Int,
    @SerialName("humidity")
    val humidity: Double,
    @SerialName("precipitationProbability")
    val precipitationProbability: Int,
    @SerialName("pressureSurfaceLevel")
    val pressureSurfaceLevel: Double,
    @SerialName("rainIntensity")
    val rainIntensity: Int,
    @SerialName("sleetIntensity")
    val sleetIntensity: Int,
    @SerialName("snowIntensity")
    val snowIntensity: Int,
    @SerialName("temperature")
    val temperature: Double,
    @SerialName("temperatureApparent")
    val temperatureApparent: Double,
    @SerialName("uvHealthConcern")
    val uvHealthConcern: Int,
    @SerialName("uvIndex")
    val uvIndex: Int,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("weatherCode")
    val weatherCode: Int,
    @SerialName("windDirection")
    val windDirection: Double,
    @SerialName("windGust")
    val windGust: Double,
    @SerialName("windSpeed")
    val windSpeed: Double
)