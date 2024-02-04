package com.example.weatherbackend.service;

import com.example.weatherbackend.dto.CurrentWeatherResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrentWeatherResponseServiceImpl implements CurrentWeatherResponseService {
    @Value("${weather-api-key}")
    private String apiKey;

    @Override
    public JsonElement fetchWeatherData(String city) {
        final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&lang=tr&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(API_URL, Object.class);
        Object object = responseEntity.getBody();
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(object);
        return jsonElement;
    }

    @Override
    public CurrentWeatherResponse getCurrentWeather(String city) {
        JsonElement jsonElement = fetchWeatherData(city);
        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();

        currentWeatherResponse.setCity(jsonElement.getAsJsonObject().get("name").getAsString());
        currentWeatherResponse.setTemperature(jsonElement.getAsJsonObject().get("main").getAsJsonObject().get("temp").
                getAsDouble());
        currentWeatherResponse.setDescription(jsonElement.getAsJsonObject().get("weather").getAsJsonArray().get(0).
                getAsJsonObject().get("description").getAsString());
        currentWeatherResponse.setCountry(jsonElement.getAsJsonObject().get("sys").getAsJsonObject().get("country")
                .getAsString());
        currentWeatherResponse.setWindSpeed(jsonElement.getAsJsonObject().get("wind").getAsJsonObject().get("speed")
                .getAsDouble());

        return currentWeatherResponse;
    }
}
