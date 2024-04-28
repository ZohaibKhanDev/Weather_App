package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timelines(
    @SerialName("daily")
    val daily: List<Daily>,
    @SerialName("hourly")
    val hourly: List<Hourly>,
    @SerialName("minutely")
    val minutely: List<Minutely>
)