package com.example.restservice;

public class Weather {
    private long id;
    private String weather_content,location;

    public Weather(long id, String weather_content,String location) {
        this.id = id;
        this.weather_content = weather_content;
        this.location = location;
    }

    public long getId(){
        return id;
    }

    public String getContent(){
        return weather_content;
    }

    public String getLocation() {
        return location;
    }
}

