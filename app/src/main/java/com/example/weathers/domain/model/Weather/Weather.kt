package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName("location")
    val location: Location,
    @SerialName("timelines")
    val timelines: Timelines
)