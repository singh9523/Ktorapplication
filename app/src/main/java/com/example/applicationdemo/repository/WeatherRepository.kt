package com.example.applicationdemo.repository

import android.util.Log
import com.example.applicationdemo.data.DataOrException
import com.example.applicationdemo.model.Weather
import com.example.applicationdemo.model.WeatherObject
import com.example.applicationdemo.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getWeather: $response")
        return DataOrException(data = response)
    }

}