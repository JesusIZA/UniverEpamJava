package moduleWork1.entitys;

import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TaxiStationTest {
    TaxiStation taxiStation;

    @Before
    public void setUp(){
        taxiStation = new TaxiStation(20);
    }

    @After
    public void tearDown(){
        taxiStation = null;
    }

    @Test
    public void priceOfCarPark(){
        assertTrue(taxiStation.priceOfCarPark() > 0);
    }

    @Test
    public void sortByFuelConsumption(){
        taxiStation.sortByFuelConsumption();

        Car car1 = taxiStation.carPark.next();
        Car car2 = taxiStation.carPark.next();

        assertTrue(car1.getFuelConsumption() <= car2.getFuelConsumption());
    }

    @Test
    public void findCarBySpeedRange(){
        Car car = taxiStation.findCarBySpeedRange(200 , 300);

        assertTrue(car.getSpeed() >= 200 && car.getSpeed() <= 300);
    }

}