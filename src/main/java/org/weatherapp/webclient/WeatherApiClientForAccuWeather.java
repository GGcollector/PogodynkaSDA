package org.weatherapp.webclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClientForAccuWeather implements ApiClient{
    private static final String API_URL_LOCATION = "http://dataservice.accuweather.com/locations/v1/search";
    private static final String URL_PARAMS_LOCATION = "?apikey=%s&q=%s";
    private static final String API_URL_CC = "http://dataservice.accuweather.com/currentconditions/v1/";
    private static final String URL_PARAMS_CC = "%s?apikey=%s&%s";
    private static final String URL_PARAMS_EXTRA = "details=true";
    private static final String API_KEY = "UvHAzLA1La7QFuiJTfDX1j6hNZAZCYMw"; //AccuWeather API KEY
    private static final String API_URL_HISTORICAL = "http://api.weatherstack.com/historical"; //do zmiany
    private static final String HISTORICAL_PARAM = "&historical_date=%s"; //do zmiany

//    "1-275174_1_AL"
    public HttpResponse<String> getLocationKey(final String city) throws IOException, InterruptedException {
        final String apiUrl = String.format(API_URL_LOCATION + URL_PARAMS_LOCATION, API_KEY, city);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        final HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send;
    }
// tutaj musze zmienić żeby zaciągał dane (kod lokacji).
    public HttpResponse<String> getWeather(final String city) throws IOException, InterruptedException {
        final String apiUrl = String.format(API_URL_CC + URL_PARAMS_CC,city, API_KEY, URL_PARAMS_EXTRA);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        final HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send;
    }

    @Override // do zmiany
    public HttpResponse<String> getHistoricalWeather(final String city, final String date) throws IOException, InterruptedException {
        final String apiUrl = String.format(API_URL_HISTORICAL + URL_PARAMS_LOCATION + HISTORICAL_PARAM, API_KEY, city, date);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        final HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send;
    }
}
