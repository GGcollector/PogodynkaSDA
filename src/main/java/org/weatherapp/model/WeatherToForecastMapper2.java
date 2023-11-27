package org.weatherapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherToForecastMapper2 implements ForecastMapper {
    @Override
    public Forecast mapToForecast(String json) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            final JsonNode jsonNode2 = objectMapper.readTree(json);

            Forecast forecast = new Forecast(
                    jsonNode2.get("name").asText(),
                    jsonNode2.get("sys").get("country").asText(),
                    jsonNode2.get("main").get("temp").asInt(),
                    jsonNode2.get("weather").get(0).get("description").asText());
            return forecast;
        }
    }

