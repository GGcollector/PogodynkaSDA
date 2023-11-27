package org.weatherapp.model;

import java.util.UUID;

public class ForecastAccu {

    private String city;
    private String country;
    private String key;

    public ForecastAccu(final String city, final String country, final String key) {
        this.city = city;
        this.country = country;
        this.key = key;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "ForecastAccu{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}

