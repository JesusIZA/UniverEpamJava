package moduleWork3.parsers;

import moduleWork3.entitys.Beer;
import moduleWork3.entitys.Chars;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class realized DOM parsing for these Beers
 *
 * @author Jesus Raichuk
 */
public class BeerDOMParser {
    /**
     * Logger
     */
    private static Logger logger = Logger.getLogger(BeerDOMParser.class);

    /**
     * Parsing XML Beers file
     * @param way - way to the XML file
     * @return list - list of these beers were found in the XML file
     */
    public List<Beer> parseBeersXML(String way){
        logger.info("Beer DOM parser is start!");
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
        } catch(ParserConfigurationException e) {}

        Document doc = null;
        try {
            doc = db.parse(new File(way));
        } catch (SAXException ex) { }
        catch (IOException ex){}

        // Получаем корневой элемент
        Element root = doc.getDocumentElement();
        if (root.getTagName().equals("beers"))
        {
            // Получаем коллекцию пива
            NodeList listBeers = root.getElementsByTagName("beer");
            // Create List of beers
            List<Beer> beerList = new LinkedList<Beer>();
            // Проходим по колекции пива
            for (int i = 0; i < listBeers.getLength(); i++)
            {
                // Получаем текущее пиво
                Element beer = (Element)listBeers.item(i);
                String beerId = beer.getAttribute("id");
                String beerName = beer.getAttribute("name");
                String beerType = beer.getAttribute("type");
                boolean beerAl = Boolean.parseBoolean(beer.getAttribute("al"));
                String beerManufacturer = beer.getAttribute("manufacturer");

                // Получаем коллекцию ингредиентов для пива
                Element ingr = (Element)beer.getElementsByTagName("ingredients").item(0);
                NodeList listIngredients = ingr.getElementsByTagName("ingredient");
                //Create list of ingredients
                List<String> lIngredients = new LinkedList<String>();
                // Проходим по ингредиентам
                for (int j=0; j<listIngredients.getLength(); j++)
                {
                    // Получаем текущий ингредиент
                    Element ingredient = (Element)listIngredients.item(j);
                    String ingrName = ingredient.getAttribute("name");
                    lIngredients.add(ingrName);
                }

                // Получаем характеристики текущего пива
                Element chr = (Element)beer.getElementsByTagName("chars").item(0);
                double klObor = Double.parseDouble(chr.getAttribute("klObor"));
                int opacity = Integer.parseInt(chr.getAttribute("opacity"));
                boolean filtered = Boolean.parseBoolean(chr.getAttribute("filtered"));
                double kkal = Double.parseDouble(chr.getAttribute("kkal"));;
                String tara = chr.getAttribute("tara");
                double v = Double.parseDouble(chr.getAttribute("V"));

                //Create java class Chars
                Chars chars = new Chars(klObor, opacity, filtered, kkal, tara, v);

                //Create java class Beer
                Beer beerJ = new Beer(beerId, beerName, beerType, beerAl, beerManufacturer, lIngredients, chars);

                //Add to list of beers will return
                beerList.add(beerJ);
            }
            logger.info("Beer DOM parser is finish!");
            return beerList;
        }
        logger.info("Beer DOM parser is finish!");
        return null;
    }
}
