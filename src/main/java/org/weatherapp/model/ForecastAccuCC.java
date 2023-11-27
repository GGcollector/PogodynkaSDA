package org.weatherapp.model;

public class ForecastAccuCC {
    private Integer temperature;
    private String weatherText;

    public ForecastAccuCC(Integer temperature, String weatherText) {
        this.temperature = temperature;
        this.weatherText = weatherText;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getWeatherText() {
        return weatherText;
    }

    @Override
    public String toString() {
        return "ForecastAccuCC{" +
                "temperature=" + temperature +
                ", WeatherText='" + weatherText + '\'' +
                '}';
    }
}
