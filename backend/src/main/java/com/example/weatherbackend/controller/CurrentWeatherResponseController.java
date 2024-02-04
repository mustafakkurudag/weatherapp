package com.example.weatherbackend.controller;

import com.example.weatherbackend.dto.CurrentWeatherResponse;
import com.example.weatherbackend.service.CurrentWeatherResponseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class CurrentWeatherResponseController {

    private CurrentWeatherResponseService currentWeatherResponseService;

    public CurrentWeatherResponseController(CurrentWeatherResponseService currentWeatherResponseService) {
        this.currentWeatherResponseService = currentWeatherResponseService;
    }

    @GetMapping("/weather")
    public CurrentWeatherResponse getWeather(@RequestParam("city") String city) {
        return currentWeatherResponseService.getCurrentWeather(city);
    }
}
