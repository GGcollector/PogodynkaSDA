package org.weatherapp.webclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClientForAccuWeather implements ApiClient{
    private static final String API_URL = "http://dataservice.accuweather.com/locations/v1/search";
    private static final String URL_PARAMS = "?apikey=%s&q=%s";
    private static final String URL_PARAMS_EXTRA = "language=PL&details=true";
    private static final String API_KEY = "UvHAzLA1La7QFuiJTfDX1j6hNZAZCYMw"; //AccuWeather API KEY
    private static final String API_URL_HISTORICAL = "http://api.weatherstack.com/historical"; //do zmiany
    private static final String HISTORICAL_PARAM = "&historical_date=%s"; //do zmiany


//"http://dataservice.accuweather.com/locations/v1/search?apikey=UvHAzLA1La7QFuiJTfDX1j6hNZAZCYMw&q=Gdansk&language=PL&details=true"
    @Override
    public HttpResponse<String> getWeather(final String city) throws IOException, InterruptedException {
        final String apiUrl = String.format(API_URL + URL_PARAMS, API_KEY, city, URL_PARAMS_EXTRA);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        final HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return send;
    }

    @Override // do zmiany
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
