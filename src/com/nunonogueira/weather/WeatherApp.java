package com.nunonogueira.weather;

import java.io.IOException;
import java.util.Scanner;


public class WeatherApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What city would you like to see the weather forecast for? ");
        String city = scanner.nextLine();

        WeatherAPI api = new WeatherAPI();
        String forecast = api.getForecast(city);

        WeatherResponseParser parser = new WeatherResponseParser();
        parser.parseAndPrint(forecast);
    }
}
