package homeWorks.weather.interfaces;

/**
 * Pattern Observer
 *
 * Weather observer
 */
public interface Observer {
    /**
     * Method update all parameters of weather
     * @param temperature - temperature
     * @param windSpeed - wind speed
     * @param pressure - atmospheric pressure
     */
    public void update(float temperature, float windSpeed, float pressure);
}
