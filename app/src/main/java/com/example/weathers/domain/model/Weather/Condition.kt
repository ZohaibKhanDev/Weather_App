package com.example.weathers.domain.model.Weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    @SerialName("code")
    val code: Int,
    @SerialName("icon")
    val icon: String,
    @SerialName("text")
    val text: String
)