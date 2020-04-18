package com.example.restservice;

public class WeatherForecast {
    private int id;
    private String content;
    private String lat,lon;

    public WeatherForecast(int id, String content, String lat, String lon) {
        this.id = id;
        this.content = content;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
