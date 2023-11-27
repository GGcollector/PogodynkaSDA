package org.weatherapp;

import org.weatherapp.model.Forecast;
import org.weatherapp.model.WeatherToForecastMapper;
import org.weatherapp.model.WeatherToForecastMapper2;
import org.weatherapp.model.WeatherToForecastMapper3;
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
//        WeatherApiClientForOpenWeather weatherApiClientForOpenWeather = new WeatherApiClientForOpenWeather();
//        WeatherToForecastMapper2 weatherToForecastMapper2 = new WeatherToForecastMapper2();
//        HttpResponse<String> responseOP = weatherApiClientForOpenWeather.getWeather("Gdansk");
////        System.out.println(responseOP.body());
//        System.out.println("To jest nasz drugi obiekt:");
//        Forecast forecastOP = weatherToForecastMapper2.mapToForecast(responseOP.body());
//        System.out.println(forecastOP.toString());

        WeatherApiClientForAccuWeather weatherApiClientForAccuWeather = new WeatherApiClientForAccuWeather();
        WeatherToForecastMapper3 weatherToForecastMapper3 = new WeatherToForecastMapper3();
        HttpResponse<String> responseAccu = weatherApiClientForAccuWeather.getWeather("Gdansk");
        System.out.println(responseAccu.body());



    }
}