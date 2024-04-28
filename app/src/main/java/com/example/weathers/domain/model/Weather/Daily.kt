package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("time")
    val time: String,
    @SerialName("values")
    val values: Values
)