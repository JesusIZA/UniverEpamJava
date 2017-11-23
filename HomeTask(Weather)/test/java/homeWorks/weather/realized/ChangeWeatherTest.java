package homeWorks.weather.realized;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeWeatherTest {
    ChangeWeather changeWeather;
    WeatherDisplay weatherDisplay;
    @Before
    public void setUp() throws Exception {
        changeWeather = new ChangeWeather();
        weatherDisplay = new WeatherDisplay(changeWeather);
    }

    @After
    public void tearDown() throws Exception {
        changeWeather = null;
    }

    @Test
    public void measurementsChange() throws Exception {
        float expected = 0f;

        changeWeather.setMeasurements(0.5f, 0.5f, 0.5f);

        assertEquals(expected, changeWeather.getLastTemperature(), 0);
        assertEquals(expected, changeWeather.getLastWindSpeed(), 0);
        assertEquals(expected, changeWeather.getLastPressure(), 0);

        float expected2 = 1.5f;

        changeWeather.setMeasurements(1.5f, 1.5f, 1.5f);

        assertEquals(expected2, changeWeather.getLastTemperature(), 0);
        assertEquals(expected2, changeWeather.getLastWindSpeed(), 0);
        assertEquals(expected2, changeWeather.getLastPressure(), 0);
    }

}