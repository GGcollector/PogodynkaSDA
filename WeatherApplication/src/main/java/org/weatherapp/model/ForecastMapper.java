package org.weatherapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ForecastMapper {

    Forecast mapToForecast(String json) throws JsonProcessingException;

}
