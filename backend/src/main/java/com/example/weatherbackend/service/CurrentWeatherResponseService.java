package com.example.weatherbackend.service;

import com.example.weatherbackend.dto.CurrentWeatherResponse;
import com.google.gson.JsonElement;

public interface CurrentWeatherResponseService {
    JsonElement fetchWeatherData(String city);
    CurrentWeatherResponse getCurrentWeather(String city);
}
