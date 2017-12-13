package moduleWork3.parsers;

import moduleWork3.domain.Main;
import moduleWork3.entitys.Beer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BeerDOMParserTest {
    public static final String WAY = "D:\\ForCreate(ua.jrc)\\Java\\Java9.1\\EPAM17\\M-Module-3\\src\\main\\resources\\BeersTest.xml";
    BeerDOMParser bdp;
    List<Beer> beerList;
    @Before
    public void setUp() throws Exception {
        bdp = new BeerDOMParser();
        beerList = bdp.parseBeersXML(WAY);
    }

    @After
    public void tearDown() throws Exception {
        bdp = null;
        beerList = null;
    }

    @Test
    public void parseBeersXML() throws Exception {
        assertTrue(beerList.size() == 2);
        assertTrue(beerList.get(0).getId().equals("b1"));
        assertTrue(beerList.get(0).getAl());
        assertTrue(beerList.get(1).getIngredients().get(0).equals("water"));
        assertFalse(beerList.get(1).getCrs().isFiltered());
    }

}