package com.example.restservice;

import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WeatherController {

    public static void main(String[] args) {
        SpringApplication.run(WeatherController.class, args);
    }

    private int a;
    private String content;



    @GetMapping("/weather/forecast")
    public WeatherForecast forecast (@RequestParam(value = "lat")String lat , @RequestParam(value = "lon") String lon) {
        try {
            //Real Weather API URL//
            String url = "https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&appid=bd7aab0f0a6f00e7cd6f6c2cc738bd7f";

            URL obj1 = new URL(url);
            //Opening Connection
            HttpURLConnection con = (HttpURLConnection) obj1.openConnection();

            int responsecode = con.getResponseCode();

            //To read the response//
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            a = responsecode;
            content = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Printing response//
        return new WeatherForecast(a,content,lat,lon);
    }

    @GetMapping("/weather/current")
    public Weather current (@RequestParam(value = "location" )String location) {
        try {
            //Real Weather API URL//
            String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid=bd7aab0f0a6f00e7cd6f6c2cc738bd7f";

            URL obj = new URL(url);
            //Opening Connection
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responsecode = con.getResponseCode();

            //To read the response//
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            a = responsecode;
            content = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Printing response//
        return new Weather(a,content,location);
    }

}

