package homeWorks.weather.realized;


import homeWorks.weather.interfaces.Observer;
import homeWorks.weather.interfaces.Subject;

import java.util.ArrayList;

/**
 * Class realized Observer Subject
 * Send message to display when weather is change
 *
 * @author Jesus Raichuk
 */
public class ChangeWeather implements Subject {
    /**
     * Last temperature parameter
     */
    private float lastTemperature;
    /**
     * Last wind speed parameter
     */
    private float lastWindSpeed;
    /**
     * Last atmospheric pressure parameter
     */
    private float lastPressure;
    /**
     * Current temperature parameter
     */
    private float temperature;
    /**
     * Current wind speed parameter
     */
    private float windSpeed;
    /**
     * Current atmospheric pressure parameter
     */
    private float pressure;
    /**
     * List of observers (clients)
     */
    private ArrayList observers;

    public ChangeWeather () {
        observers = new ArrayList<Observer>();
        lastTemperature = 0f;
        lastWindSpeed = 0f;
        lastPressure = 0f;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getPressure() {
        return pressure;
    }

    public float getLastTemperature() {
        return lastTemperature;
    }

    public float getLastWindSpeed() {
        return lastWindSpeed;
    }

    public float getLastPressure() {
        return lastPressure;
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        if(observers.indexOf(obs) >= 0){
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer obs = (Observer)observers.get(i);
            ((Observer) observers.get(i)).update(temperature, windSpeed, pressure);
        }
    }

    /**
     * Method decide need send clients change or not
     */
    public void measurementsChange(){
        if (Math.abs(lastTemperature - temperature) > 1 ||
                Math.abs(lastWindSpeed - windSpeed) > 1 ||
                Math.abs(lastPressure - pressure) > 1) {
            notifyObservers();
            this.lastTemperature = this.temperature;
            this.lastWindSpeed = this.windSpeed;
            this.lastPressure = this.pressure;
        }
    }
    /**
     * Method set all parameters of weather and start method "measurementsChange()"
     * @param temperature - temperature
     * @param windSpeed - wind speed
     * @param pressure - atmospheric pressure
     */
    public  void setMeasurements(float temperature, float windSpeed, float pressure){
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        measurementsChange();
    }
}
