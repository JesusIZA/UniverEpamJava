package moduleWork3.parsers.stax;

import moduleWork3.entitys.Beer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BeerStAXParserTest {
    public static final String WAY = "M-Module-3/src/main/resources/BeersTest.xml";
    BeerStAXParser bstp;
    List<Beer> beerList;
    @Before
    public void setUp() throws Exception {
        bstp = new BeerStAXParser();
        beerList = bstp.parseXML(WAY);
    }

    @After
    public void tearDown() throws Exception {
        bstp = null;
        beerList = null;
    }

    @Test
    public void parseBeersXML() throws Exception {
        assertTrue(beerList.size() == 2);
        assertTrue(beerList.get(0).getId().equals("b1"));
        assertTrue(beerList.get(1).getManufacturer().equals("OnolonKyiv"));
        //assertTrue(beerList.get(0).getIngredients().get(1).equals("hop"));
        assertTrue(beerList.get(1).getCrs().getV() == 0.5);
    }

}