package homeWorks.weather.generators;

/**
 * Class generate random weather
 *
 * @author Jesus Raichuk
 */
public abstract class RandomWeatherGenerator {
    /**
     * Generate random temperature
     * @return - float random
     */
    public static float randomTemperature() {
        return (float)(Math.random() + Math.random() * 2 + 10);
    }
    /**
     * Generate random wind speed
     * @return - float random
     */
    public static float randomWindSpeed() {
        return (float)(Math.random() + Math.random() * 2 + 60);
    }
    /**
     * Generate random atmospheric pressure
     * @return - float random
     */
    public static float randomPressure() {
        return (float)(Math.random() + Math.random() * 2 + 800);
    }
}
