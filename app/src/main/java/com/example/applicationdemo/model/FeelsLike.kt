package com.example.applicationdemo.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FeelsLike(
    @SerialName("day")
    val day: Double,
    @SerialName("eve")
    val eve: Double,
    @SerialName("morn")
    val morn: Double,
    @SerialName("night")
    val night: Double
)