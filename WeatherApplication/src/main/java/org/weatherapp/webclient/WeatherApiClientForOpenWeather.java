package org.weatherapp.webclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClientForOpenWeather implements ApiClient {

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String URL_PARAMS = "?q=%s&appid=%s";
    private static final String API_KEY = "9a25cb7505cd23e183fdf38f496c16e3"; //openweather API KEY
    private static final String API_URL_HISTORICAL = "http://api.weatherstack.com/historical"; //do zmiany
    private static final String HISTORICAL_PARAM = "&historical_date=%s"; //do zmiany
    // Pamiętej, żeby zmienić API KEY na swój


    @Override
    public HttpResponse<String> getWeather(final String city) throws IOException, InterruptedException {
        final String apiUrl = String.format(API_URL + URL_PARAMS, city, API_KEY);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        final HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send;
    }

    @Override// do zmiany
    public HttpResponse<String> getHistoricalWeather(final String city, final String date) throws IOException, InterruptedException {
        final String apiUrl = String.format(API_URL_HISTORICAL + URL_PARAMS + HISTORICAL_PARAM, API_KEY, city, date);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        final HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send;
    }

}
