package homeWorks.weather.domain;

import homeWorks.weather.generators.RandomWeatherGenerator;
import homeWorks.weather.realized.ChangeWeather;
import homeWorks.weather.realized.WeatherDisplay;

/**
 * Weather
 * 
 * @author Jesus Raichuk
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChangeWeather changeWeather = new ChangeWeather();
        WeatherDisplay weatherDisplay = new WeatherDisplay(changeWeather);

        while(true) {
            changeWeather.setMeasurements(RandomWeatherGenerator.randomTemperature(), RandomWeatherGenerator.randomWindSpeed(),
                    RandomWeatherGenerator.randomPressure());
            Thread.sleep(1000);
        }
    }
}
