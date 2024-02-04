package com.example.weatherbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeatherResponse {

    private String city;
    private Double temperature;
    private String description;
    private String country;
    private Double windSpeed;

}
