package xyz.shiqihao.designpattern.behavioral.observer.example_1;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    public static void main(String[] args) {
        List<Observer> observers = new ArrayList<>();
        WeatherData weatherData = new WeatherData(observers);
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurement(1.0, 2.0, 3.0);
        currentDisplay.unregister();
        weatherData.setMeasurement(100.0, 200.0, 300.0);
    }
}
