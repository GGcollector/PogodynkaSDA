package org.weatherapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ForecastMapperForAccu {

    ForecastAccu mapToForecast(String json) throws JsonProcessingException;
}
