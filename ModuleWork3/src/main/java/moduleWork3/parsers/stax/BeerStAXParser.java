package moduleWork3.parsers.stax;

import moduleWork3.entitys.Beer;
import moduleWork3.entitys.Chars;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class realized StAX parsing for these Beers
 *
 * @author Jesus Raichuk
 */
public class BeerStAXParser {
    /**
     * List of these beers will return
     */
    private List<Beer> beers = new ArrayList<Beer>();
    /**
     * Logger
     */
    private static Logger logger = Logger.getLogger(BeerStAXParser.class);

    /**
     * Parsing XML Beers file
     * @param fileName - way to the XML file
     * @return list - list of these beers weer found in the XML file
     */
    public List<Beer> parseXML(String fileName) {
        logger.info("Beer StAX parser is start!");
        Beer beer = null;
        Chars crs = new Chars();
        List<String> ingrs = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if(startElement.getName().getLocalPart().equals("beer")){
                        beer = new Beer();
                        //Get the 'id' attribute from Beer element
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if(idAttr != null){
                            beer.setId(idAttr.getValue());
                        }
                        //Get the 'name' attribute from Beer element
                        Attribute nameAttr = startElement.getAttributeByName(new QName("name"));
                        if(nameAttr != null){
                            beer.setName(nameAttr.getValue());
                        }
                        //Get the 'type' attribute from Beer element
                        Attribute typeAttr = startElement.getAttributeByName(new QName("type"));
                        if(typeAttr != null){
                            beer.setType(typeAttr.getValue());
                        }
                        //Get the 'al' attribute from Beer element
                        Attribute alAttr = startElement.getAttributeByName(new QName("al"));
                        if(alAttr != null){
                            beer.setAl(Boolean.parseBoolean(alAttr.getValue()));
                        }
                        //Get the 'manufacturer' attribute from Beer element
                        Attribute manufacturerAttr = startElement.getAttributeByName(new QName("manufacturer"));
                        if(manufacturerAttr != null){
                            beer.setManufacturer(manufacturerAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("ingredients")) {
                        ingrs = new ArrayList<String>();
                    } else if (startElement.getName().getLocalPart().equals("ingredient")) {
                        //Get the 'name' attribute from Ingredient element
                        Attribute nameAttr = startElement.getAttributeByName(new QName("name"));
                        if(nameAttr != null){
                            ingrs.add(nameAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("chars")) {
                        //Get the 'klObor' attribute from Chars element
                        Attribute klOborAttr = startElement.getAttributeByName(new QName("klObor"));
                        if(klOborAttr != null){
                            crs.setKlObor(Double.parseDouble(klOborAttr.getValue()));
                        }
                        //Get the 'opacity' attribute from Chars element
                        Attribute opacityAttr = startElement.getAttributeByName(new QName("opacity"));
                        if(opacityAttr != null){
                            crs.setOpacity(Integer.parseInt(opacityAttr.getValue()));
                        }
                        //Get the 'filtered' attribute from Chars element
                        Attribute filteredAttr = startElement.getAttributeByName(new QName("filtered"));
                        if(filteredAttr != null){
                            crs.setFiltered(Boolean.parseBoolean(filteredAttr.getValue()));
                        }
                        //Get the 'kkal' attribute from Chars element
                        Attribute kkalAttr = startElement.getAttributeByName(new QName("kkal"));
                        if(kkalAttr != null){
                            crs.setKkal(Double.parseDouble(kkalAttr.getValue()));
                        }
                        //Get the 'tara' attribute from Chars element
                        Attribute taraAttr = startElement.getAttributeByName(new QName("tara"));
                        if(taraAttr != null){
                            crs.setTara(taraAttr.getValue());
                        }
                        //Get the 'V' attribute from Chars element
                        Attribute vAttr = startElement.getAttributeByName(new QName("V"));
                        if(vAttr != null){
                            crs.setV(Double.parseDouble(vAttr.getValue()));
                        }

                        beer.setCrs(crs);
                    }

                }
                //if Employee end element is reached, add employee object to list
                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("ingredients")){
                        beer.setIngredients(ingrs);
                    }
                    if(endElement.getName().getLocalPart().equals("beer")){
                        beers.add(beer);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            logger.error("Standard exception -> " + fileName + " - File not found!");
            return beers;
        }
        logger.info("Beer StAX parser is finish!");
        return beers;
    }
}
