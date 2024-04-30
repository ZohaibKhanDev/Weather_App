package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName("current")
    val current: Current?=null,
    @SerialName("location")
    val location: Location?=null
)