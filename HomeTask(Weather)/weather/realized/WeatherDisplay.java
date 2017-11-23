package homeWorks.weather.realized;

import homeWorks.weather.interfaces.DisplayElement;
import homeWorks.weather.interfaces.Observer;
import homeWorks.weather.interfaces.Subject;

/**
 * Class display weather parameters on console
 *
 * @author Jesus Raichuk
 */
public class WeatherDisplay implements Observer, DisplayElement {
    /**
     * Current temperature
     */
    private float temperature;
    /**
     * Current wind speed
     */
    private float windSpeed;
    /**
     * Current atmospheric pressure
     */
    private float pressure;
    /**
     * Weather observer subject
     */
    Subject weatherObserver;

    public WeatherDisplay(Subject numObserver) {
        this.weatherObserver = numObserver;
        numObserver.registerObserver(this);
    }

    @Override
    public void update(float temperature, float windSpeed, float pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Temperature: " + temperature + " Wind speed: " + windSpeed + " Atmospheric pressure: " + pressure);
    }
}
