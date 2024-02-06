package com.example.applicationdemo.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(
    @SerialName("coord")
    val coord: Coord,
    @SerialName("country")
    val country: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("population")
    val population: Int,
    @SerialName("timezone")
    val timezone: Int
)