package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Values(
    @SerialName("cloudBaseAvg")
    val cloudBaseAvg: Double,
    @SerialName("cloudBaseMax")
    val cloudBaseMax: Double,
    @SerialName("cloudBaseMin")
    val cloudBaseMin: Double,
    @SerialName("cloudCeilingAvg")
    val cloudCeilingAvg: Double,
    @SerialName("cloudCeilingMax")
    val cloudCeilingMax: Double,
    @SerialName("cloudCeilingMin")
    val cloudCeilingMin: Int,
    @SerialName("cloudCoverAvg")
    val cloudCoverAvg: Double,
    @SerialName("cloudCoverMax")
    val cloudCoverMax: Double,
    @SerialName("cloudCoverMin")
    val cloudCoverMin: Double,
    @SerialName("dewPointAvg")
    val dewPointAvg: Double,
    @SerialName("dewPointMax")
    val dewPointMax: Double,
    @SerialName("dewPointMin")
    val dewPointMin: Double,
    @SerialName("evapotranspirationAvg")
    val evapotranspirationAvg: Double,
    @SerialName("evapotranspirationMax")
    val evapotranspirationMax: Double,
    @SerialName("evapotranspirationMin")
    val evapotranspirationMin: Double,
    @SerialName("evapotranspirationSum")
    val evapotranspirationSum: Double,
    @SerialName("freezingRainIntensityAvg")
    val freezingRainIntensityAvg: Int,
    @SerialName("freezingRainIntensityMax")
    val freezingRainIntensityMax: Int,
    @SerialName("freezingRainIntensityMin")
    val freezingRainIntensityMin: Int,
    @SerialName("humidityAvg")
    val humidityAvg: Double,
    @SerialName("humidityMax")
    val humidityMax: Double,
    @SerialName("humidityMin")
    val humidityMin: Double,
    @SerialName("iceAccumulationAvg")
    val iceAccumulationAvg: Int,
    @SerialName("iceAccumulationLweAvg")
    val iceAccumulationLweAvg: Int,
    @SerialName("iceAccumulationLweMax")
    val iceAccumulationLweMax: Int,
    @SerialName("iceAccumulationLweMin")
    val iceAccumulationLweMin: Int,
    @SerialName("iceAccumulationLweSum")
    val iceAccumulationLweSum: Int,
    @SerialName("iceAccumulationMax")
    val iceAccumulationMax: Int,
    @SerialName("iceAccumulationMin")
    val iceAccumulationMin: Int,
    @SerialName("iceAccumulationSum")
    val iceAccumulationSum: Int,
    @SerialName("moonriseTime")
    val moonriseTime: String,
    @SerialName("moonsetTime")
    val moonsetTime: String,
    @SerialName("precipitationProbabilityAvg")
    val precipitationProbabilityAvg: Double,
    @SerialName("precipitationProbabilityMax")
    val precipitationProbabilityMax: Int,
    @SerialName("precipitationProbabilityMin")
    val precipitationProbabilityMin: Int,
    @SerialName("pressureSurfaceLevelAvg")
    val pressureSurfaceLevelAvg: Double,
    @SerialName("pressureSurfaceLevelMax")
    val pressureSurfaceLevelMax: Double,
    @SerialName("pressureSurfaceLevelMin")
    val pressureSurfaceLevelMin: Double,
    @SerialName("rainAccumulationAvg")
    val rainAccumulationAvg: Double,
    @SerialName("rainAccumulationLweAvg")
    val rainAccumulationLweAvg: Double,
    @SerialName("rainAccumulationLweMax")
    val rainAccumulationLweMax: Double,
    @SerialName("rainAccumulationLweMin")
    val rainAccumulationLweMin: Int,
    @SerialName("rainAccumulationMax")
    val rainAccumulationMax: Double,
    @SerialName("rainAccumulationMin")
    val rainAccumulationMin: Int,
    @SerialName("rainAccumulationSum")
    val rainAccumulationSum: Double,
    @SerialName("rainIntensityAvg")
    val rainIntensityAvg: Double,
    @SerialName("rainIntensityMax")
    val rainIntensityMax: Double,
    @SerialName("rainIntensityMin")
    val rainIntensityMin: Int,
    @SerialName("sleetAccumulationAvg")
    val sleetAccumulationAvg: Int,
    @SerialName("sleetAccumulationLweAvg")
    val sleetAccumulationLweAvg: Int,
    @SerialName("sleetAccumulationLweMax")
    val sleetAccumulationLweMax: Int,
    @SerialName("sleetAccumulationLweMin")
    val sleetAccumulationLweMin: Int,
    @SerialName("sleetAccumulationLweSum")
    val sleetAccumulationLweSum: Int,
    @SerialName("sleetAccumulationMax")
    val sleetAccumulationMax: Int,
    @SerialName("sleetAccumulationMin")
    val sleetAccumulationMin: Int,
    @SerialName("sleetIntensityAvg")
    val sleetIntensityAvg: Int,
    @SerialName("sleetIntensityMax")
    val sleetIntensityMax: Int,
    @SerialName("sleetIntensityMin")
    val sleetIntensityMin: Int,
    @SerialName("snowAccumulationAvg")
    val snowAccumulationAvg: Int,
    @SerialName("snowAccumulationLweAvg")
    val snowAccumulationLweAvg: Int,
    @SerialName("snowAccumulationLweMax")
    val snowAccumulationLweMax: Int,
    @SerialName("snowAccumulationLweMin")
    val snowAccumulationLweMin: Int,
    @SerialName("snowAccumulationLweSum")
    val snowAccumulationLweSum: Int,
    @SerialName("snowAccumulationMax")
    val snowAccumulationMax: Int,
    @SerialName("snowAccumulationMin")
    val snowAccumulationMin: Int,
    @SerialName("snowAccumulationSum")
    val snowAccumulationSum: Int,
    @SerialName("snowDepthAvg")
    val snowDepthAvg: Int?,
    @SerialName("snowDepthMax")
    val snowDepthMax: Int?,
    @SerialName("snowDepthMin")
    val snowDepthMin: Int?,
    @SerialName("snowDepthSum")
    val snowDepthSum: Int?,
    @SerialName("snowIntensityAvg")
    val snowIntensityAvg: Int,
    @SerialName("snowIntensityMax")
    val snowIntensityMax: Int,
    @SerialName("snowIntensityMin")
    val snowIntensityMin: Int,
    @SerialName("sunriseTime")
    val sunriseTime: String,
    @SerialName("sunsetTime")
    val sunsetTime: String,
    @SerialName("temperatureApparentAvg")
    val temperatureApparentAvg: Double,
    @SerialName("temperatureApparentMax")
    val temperatureApparentMax: Double,
    @SerialName("temperatureApparentMin")
    val temperatureApparentMin: Double,
    @SerialName("temperatureAvg")
    val temperatureAvg: Double,
    @SerialName("temperatureMax")
    val temperatureMax: Double,
    @SerialName("temperatureMin")
    val temperatureMin: Double,
    @SerialName("uvHealthConcernAvg")
    val uvHealthConcernAvg: Int?,
    @SerialName("uvHealthConcernMax")
    val uvHealthConcernMax: Int?,
    @SerialName("uvHealthConcernMin")
    val uvHealthConcernMin: Int?,
    @SerialName("uvIndexAvg")
    val uvIndexAvg: Int?,
    @SerialName("uvIndexMax")
    val uvIndexMax: Int?,
    @SerialName("uvIndexMin")
    val uvIndexMin: Int?,
    @SerialName("visibilityAvg")
    val visibilityAvg: Double,
    @SerialName("visibilityMax")
    val visibilityMax: Double,
    @SerialName("visibilityMin")
    val visibilityMin: Double,
    @SerialName("weatherCodeMax")
    val weatherCodeMax: Int,
    @SerialName("weatherCodeMin")
    val weatherCodeMin: Int,
    @SerialName("windDirectionAvg")
    val windDirectionAvg: Double,
    @SerialName("windGustAvg")
    val windGustAvg: Double,
    @SerialName("windGustMax")
    val windGustMax: Double,
    @SerialName("windGustMin")
    val windGustMin: Double,
    @SerialName("windSpeedAvg")
    val windSpeedAvg: Double,
    @SerialName("windSpeedMax")
    val windSpeedMax: Double,
    @SerialName("windSpeedMin")
    val windSpeedMin: Double
)