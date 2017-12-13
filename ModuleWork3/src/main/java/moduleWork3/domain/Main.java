package moduleWork3.domain;

import moduleWork3.entitys.Beer;
import moduleWork3.exceptions.OpacityException;
import moduleWork3.parsers.BeerDOMParser;
import moduleWork3.parsers.sax.BeerSAXParser;
import moduleWork3.parsers.stax.BeerStAXParser;
import org.apache.log4j.Logger;
import utilsforall.lists.PrintLists;

import java.util.List;

/**
 *Task 3
 * 1.	Создать файл XML и соответствующую ему схему XSD.
 * 2.	При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения,
 * обязательно использование атрибутов и типа ID.
 * 3.	Сгенерировать (создать) Java-класс, соответствующий данному описанию.
 * 4.	Создать Java-приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла.
 * Для разбора использовать SAX, DOM и StAX парсеры.
 * Для сортировки объектов использовать интерфейс Comparator.
 * 5.	Произвести проверку XML-документа с привлечением XSD.
 * 6.	Определить метод, производящий преобразование разработанного XML-документа в документ, указанный в каждом задании.
 *
 * 10.	Пиво.
 * •	Name – название пива.
 * •	Type – тип пива (темное, светлое, лагерное, живое).
 * •	Al – алкогольное либо нет.
 * •	Manufacturer – фирма-производитель.
 * •	Ingredients (должно быть несколько) – ингредиенты: вода, солод, хмель, сахар и т.д.
 * •	Chars (должно быть несколько) – характеристики: кол-во оборотов (если алкогольное), прозрачность (в процентах),
 * фильтрованное либо нет, пищевая ценность (ккал), способ разлива (объем и материал емкостей)
 * •	Корневой элемент назвать Beer.
 *
 * @author Jesus Raichuk
 */

public class Main {
    /**
     * Way to xml file will process
     */
    public static final String WAY = "D:\\ForCreate(ua.jrc)\\Java\\Java9.1\\EPAM17\\M-Module-3\\src\\main\\resources\\Beers.xml";
    /**
     * Logger
     */
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //DOM parsing
        System.out.println();
        logger.info("Start DOM parsing!");
        BeerDOMParser domParser = new BeerDOMParser();
        List<Beer> beerList = domParser.parseBeersXML(WAY);
        PrintLists.printListByRows(beerList);
        logger.info("Finish DOM parsing!");
        //SAZ parsing
        System.out.println();
        logger.info("Start SAX parsing!");
        BeerSAXParser beerSAXParser = new BeerSAXParser();
        beerList = beerSAXParser.parseBeers(WAY);
        PrintLists.printListByRows(beerList);
        logger.info("Finish SAX parsing!");
        //StAX parsing
        System.out.println();
        logger.info("Start StAX parsing!");
        BeerStAXParser beerStAXParser = new BeerStAXParser();
        beerList = beerStAXParser.parseXML(WAY);
        PrintLists.printListByRows(beerList);
        logger.info("Finish StAX parsing!");
    }
}
