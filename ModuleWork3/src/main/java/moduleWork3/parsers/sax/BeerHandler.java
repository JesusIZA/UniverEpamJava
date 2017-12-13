package moduleWork3.parsers.sax;

import moduleWork3.entitys.Beer;
import moduleWork3.entitys.Chars;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Class realize DefaultHandler for the SAX parsing XML Beer file
 * @author Jesus Raichuk
 */
public class BeerHandler extends DefaultHandler {
    /**
     * List of beers will contain found beers
     */
    List<Beer> beers = new ArrayList<Beer>();
    /**
     * The beer will constructed when we will read one beer tag
     */
    private Beer beer;
    /**
     * Chars for that beer will constructed when we will read one beer tag
     */
    private Chars crs = new Chars();
    /**
     * List of these ingredients for that beer will constructed when we will read one beer tag
     */
    private List<String> ingrs;

    public List<Beer> getBeers() {
        return beers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("beer")) {
            beer = new Beer();

            String bId = attributes.getValue("id");
            String bName = attributes.getValue("name");
            String bType = attributes.getValue("type");
            boolean bAl = Boolean.parseBoolean(attributes.getValue("al"));
            String bManufacturer = attributes.getValue("manufacturer");

            beer.setId(bId);
            beer.setName(bName);
            beer.setType(bType);
            beer.setAl(bAl);
            beer.setManufacturer(bManufacturer);

        } else if (qName.equalsIgnoreCase("ingredients")) {
            ingrs = new ArrayList<String>();
        } else if (qName.equalsIgnoreCase("ingredient")) {
            String ingr = attributes.getValue("name");
            ingrs.add(ingr);
        } else if (qName.equalsIgnoreCase("chars")) {
            double cKlObor = Double.parseDouble(attributes.getValue("klObor"));
            int cOpacity = Integer.parseInt(attributes.getValue("opacity"));
            boolean cFiltered = Boolean.parseBoolean(attributes.getValue("filtered"));
            double cKkal = Double.parseDouble(attributes.getValue("kkal"));
            String cTara = attributes.getValue("tara");
            double cV = Double.parseDouble(attributes.getValue("V"));

            crs.setKlObor(cKlObor);
            crs.setOpacity(cOpacity);
            crs.setFiltered(cFiltered);
            crs.setKkal(cKkal);
            crs.setTara(cTara);
            crs.setV(cV);

            beer.setCrs(crs);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("beer")) {
            beer.setIngredients(ingrs);
            beers.add(beer);
        }
    }
}
