package main.designpattern.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    private double temperature;
    private double humidity;
    private double pressure;

    CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: ");
        System.out.println("Temperature: " + temperature);
        System.out.println("Humility: " + humidity);
        System.out.println("Pressure: " + pressure);
        System.out.println("====================");
    }

    void unregister() {
        weatherData.removeObserver(this);
    }
}
