package org.weatherapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherToForecastMapper3 implements ForecastMapperForAccu {
    @Override
    public ForecastAccu mapToForecast(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode3 = objectMapper.readTree(json);

        ForecastAccu forecastAccu = new ForecastAccu(
                jsonNode3.get(0).get("LocalizedName").asText(),
                jsonNode3.get(0).get("Country").get("LocalizedName").asText(),
                jsonNode3.get(0).get("Key").asText());

        return forecastAccu;
    }

    public ForecastAccuCC mapToForecastToCurrentConditions(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode4 = objectMapper.readTree(json);

        ForecastAccuCC forecast = new ForecastAccuCC(
                jsonNode4.get(0).get("Temperature").get("Metric").get("Value").asInt(),
                jsonNode4.get(0).get("WeatherText").asText());
        return forecast;
    }
}
