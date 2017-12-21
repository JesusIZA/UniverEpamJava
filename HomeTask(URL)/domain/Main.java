package homeWorks.url.domain;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jesus Raichuk
 */
public class Main {
    public static void main(String[] args) {
        String word = "car";
        String[] urls = {
                "http://www.carmagazine.co.uk/car-news/first-official-pictures/tesla/tesla-electric-truck-details-and-pictures/",
                "http://www.carmagazine.co.uk/car-reviews/audi/audi-rs4-avant-2018-review/",
                "http://www.carmagazine.co.uk/car-reviews/long-term-tests/suzuki/suzuki-swift-sz5-10-boosterjet-shvs-2017-long-term-test-review/",
                "http://www.carmagazine.co.uk/car-news/first-official-pictures/tesla/tesla-model-s-shooting-brake-coming-in-2018/",
                "http://www.carmagazine.co.uk/spy-shots/bmw/new-2020-bmw-m3-codenamed-g80-revealed/",
                "http://www.carmagazine.co.uk/spy-shots/porsche/porsche-718-cayman-gt4-spy-photos-specs-and-info/",
                "http://www.carmagazine.co.uk/car-reviews/audi/audi-a4-20-tdi-190-sport-manual-2015-review/",
                "http://www.carmagazine.co.uk/car-reviews/audi/audi-a4-avant-2017-review/",
                "http://www.carmagazine.co.uk/car-news/first-official-pictures/tesla/new-tesla-roadster-revealed-pictures-price-specs/"
        };
        List<String> urlsList = Arrays.asList(urls);
        DoThis doThis = new DoThis(urlsList, word);
        doThis.doRun();
        doThis.setSeekWord("the");

        System.out.println();

        doThis.sorted();
        doThis.print();
    }
}
