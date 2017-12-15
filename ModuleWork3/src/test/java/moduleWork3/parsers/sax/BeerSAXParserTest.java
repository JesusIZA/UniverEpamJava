package moduleWork3.parsers.sax;

import moduleWork3.entitys.Beer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilsforall.lists.PrintLists;

import java.util.List;

import static org.junit.Assert.*;

public class BeerSAXParserTest {
    public static final String WAY = "M-Module-3/src/main/resources/BeersTest.xml";
    BeerSAXParser bsp;
    List<Beer> beerList;
    @Before
    public void setUp() throws Exception {
        bsp = new BeerSAXParser();
        beerList = bsp.parseBeers(WAY);
    }

    @After
    public void tearDown() throws Exception {
        bsp = null;
        beerList = null;
    }

    @Test
    public void parseBeersXML() throws Exception {
        assertTrue(beerList.size() == 2);
        assertTrue(beerList.get(1).getId().equals("b2"));
        assertTrue(beerList.get(1).getAl());
        assertTrue(beerList.get(0).getIngredients().get(2).equals("sugar"));
        assertTrue(beerList.get(0).getCrs().getTara().equals("Glass"));
    }

}