package com.shaunwassell.weather;

import java.io.IOException;

public class WeatherApp {
    public static void main(String[] args) throws IOException {
        WeatherAPI api = new WeatherAPI();
        String forecastString = api.getForecast("Detroit");

        WeatherResponseParser parser = new WeatherResponseParser();
        parser.parseAndPrint(forecastString);
    }
}
