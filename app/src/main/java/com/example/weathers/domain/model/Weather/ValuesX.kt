package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValuesX(
    @SerialName("cloudBase")
    val cloudBase: Double?,
    @SerialName("cloudCeiling")
    val cloudCeiling: Double?,
    @SerialName("cloudCover")
    val cloudCover: Double,
    @SerialName("dewPoint")
    val dewPoint: Double,
    @SerialName("evapotranspiration")
    val evapotranspiration: Double,
    @SerialName("freezingRainIntensity")
    val freezingRainIntensity: Int,
    @SerialName("humidity")
    val humidity: Double,
    @SerialName("iceAccumulation")
    val iceAccumulation: Int,
    @SerialName("iceAccumulationLwe")
    val iceAccumulationLwe: Int?,
    @SerialName("precipitationProbability")
    val precipitationProbability: Int,
    @SerialName("pressureSurfaceLevel")
    val pressureSurfaceLevel: Double,
    @SerialName("rainAccumulation")
    val rainAccumulation: Double,
    @SerialName("rainAccumulationLwe")
    val rainAccumulationLwe: Double?,
    @SerialName("rainIntensity")
    val rainIntensity: Double,
    @SerialName("sleetAccumulation")
    val sleetAccumulation: Int,
    @SerialName("sleetAccumulationLwe")
    val sleetAccumulationLwe: Int?,
    @SerialName("sleetIntensity")
    val sleetIntensity: Int,
    @SerialName("snowAccumulation")
    val snowAccumulation: Int,
    @SerialName("snowAccumulationLwe")
    val snowAccumulationLwe: Int?,
    @SerialName("snowDepth")
    val snowDepth: Int?,
    @SerialName("snowIntensity")
    val snowIntensity: Int,
    @SerialName("temperature")
    val temperature: Double,
    @SerialName("temperatureApparent")
    val temperatureApparent: Double,
    @SerialName("uvHealthConcern")
    val uvHealthConcern: Int?,
    @SerialName("uvIndex")
    val uvIndex: Int?,
    @SerialName("visibility")
    val visibility: Double,
    @SerialName("weatherCode")
    val weatherCode: Int,
    @SerialName("windDirection")
    val windDirection: Double,
    @SerialName("windGust")
    val windGust: Double,
    @SerialName("windSpeed")
    val windSpeed: Double
)