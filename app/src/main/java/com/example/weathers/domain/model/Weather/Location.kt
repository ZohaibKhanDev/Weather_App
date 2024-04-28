package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double
)