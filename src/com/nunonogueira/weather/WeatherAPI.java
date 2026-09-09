package com.nunonogueira.weather;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class WeatherAPI {

    public String getForecast(String city) throws IOException {
        Properties config = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            config.load(input);
        }

        String apiKey = config.getProperty("api.key");
        String baseUrl = config.getProperty("api.base.url");

        String apiUrl = baseUrl + "?q=" + URLEncoder.encode(city, StandardCharsets.UTF_8.toString()) + "&appid=" + apiKey + "&units=metric";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        return response.toString();

    }
}
