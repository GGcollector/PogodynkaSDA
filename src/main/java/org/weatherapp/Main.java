package org.weatherapp;

import org.weatherapp.model.*;
import org.weatherapp.webclient.WeatherApiClientForAccuWeather;
import org.weatherapp.webclient.WeatherApiClientForOpenWeather;
import org.weatherapp.webclient.WeatherApiClientForWeatherStack;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherApiClientForWeatherStack weatherApiClientForWeatherStack = new WeatherApiClientForWeatherStack();
        WeatherToForecastMapper weatherToForecastMapper = new WeatherToForecastMapper();
        final HttpResponse<String> response = weatherApiClientForWeatherStack.getWeather("Gdynia");

//        System.out.println("To jest JSON: ");
//        System.out.println(response.body());
//
//
//        Forecast forecast = weatherToForecastMapper.mapToForecast(response.body());
//        System.out.println("To jest nasz obiekt:");
//        System.out.println(forecast.toString());
////
////        final HttpResponse<String> historicalForecast = weatherApiClientForWeatherStack.getHistoricalWeather("Gdynia", "2015-01-21");
////        System.out.println("To jest nasz historical forecast:");
////
////        System.out.println(historicalForecast.body());
//
        WeatherApiClientForOpenWeather weatherApiClientForOpenWeather = new WeatherApiClientForOpenWeather();
        WeatherToForecastMapper2 weatherToForecastMapper2 = new WeatherToForecastMapper2();
        HttpResponse<String> responseOP = weatherApiClientForOpenWeather.getWeather("Gdansk");
//        System.out.println(responseOP.body());
        System.out.println("To jest nasz drugi obiekt:");
        Forecast forecastOP = weatherToForecastMapper2.mapToForecast(responseOP.body());
        System.out.println(forecastOP.toString());
        // krok 1. pobranie kodu miasta
        WeatherApiClientForAccuWeather weatherApiClientForAccuWeather = new WeatherApiClientForAccuWeather();
        WeatherToForecastMapper3 weatherToForecastMapper3 = new WeatherToForecastMapper3();
        HttpResponse<String> responseAccu = weatherApiClientForAccuWeather.getLocationKey("Gdansk");
        System.out.println(responseAccu.body());

        ForecastAccu forecastAccu = weatherToForecastMapper3.mapToForecast(responseAccu.body());
        System.out.println(forecastAccu);
        // krok 2. wyświetlenie warunków pogodowych.
//        WeatherApiClientForAccuWeather weatherApiClientForAccuWeather2 = new WeatherApiClientForAccuWeather();
//
//        WeatherToForecastMapper3 weatherToForecastMapper3v2 = new WeatherToForecastMapper3();
//
//        HttpResponse<String> responseAccuCC = weatherApiClientForAccuWeather2.getWeather(zmienna);
//
//        System.out.println(responseAccuCC);
//
//        ForecastAccuCC forecastAccu = weatherToForecastMapper3v2.mapToForecastToCurrentConditions(responseAccuCC.body());
//
//        System.out.println(forecastAccu.toString());


    }
}