package moduleWork3.parsers.sax;

import moduleWork3.entitys.Beer;
import org.apache.log4j.Logger;
import utilsforall.lists.PrintLists;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

/**
 * Class realized SAX parsing for these Beers
 *
 * @author Jesus Raichuk
 */
public class BeerSAXParser {
    /**
     * Logger
     */
    private static Logger logger = Logger.getLogger(BeerSAXParser.class);
    /**
     * Parsing XML Beers file
     * @param way - way to the XML file
     * @return list - list of these beers weer found in the XML file
     */
    public List<Beer> parseBeers(String way){
        logger.info("Beer SAX parser is start!");
        /**
         * List of these beers will return
         */
        List<Beer> b = null;
        try {
            File inputFile = new File(way);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            BeerHandler beerHandler = new BeerHandler();
            saxParser.parse(inputFile, beerHandler);

            b = beerHandler.getBeers();

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Beer SAX parser is finish!");
        return b;
    }
}
