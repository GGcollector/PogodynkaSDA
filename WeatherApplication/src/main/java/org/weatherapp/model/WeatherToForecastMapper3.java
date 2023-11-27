package org.weatherapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherToForecastMapper3 implements ForecastMapper {
    @Override // do zmiany
    public Forecast mapToForecast(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode3 = objectMapper.readTree(json);
// do poprawy
        Forecast forecast = new Forecast(
                jsonNode3.get(0).get("LocalizedName").asText(),
                jsonNode3.get(0).get("Country").get("LocalizedName").asText(),
                jsonNode3.get("main").get("temp").asInt(),
                jsonNode3.get("weather").get(0).get("description").asText());
        return forecast;
    }
}
