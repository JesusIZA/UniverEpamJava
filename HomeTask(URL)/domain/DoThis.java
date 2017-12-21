package homeWorks.url.domain;

import homeWorks.url.formap.DoMap;
import homeWorks.url.forsite.SiteWorker;

import java.io.IOException;
import java.util.*;

/**
 * @author Jesus Raichuk
 */
public class DoThis {
    private static final byte MAX = 7;
    private String seekWord;
    private String initialUrl;
    private List<String> urls;
    Map<String, Map<String, Integer>> sortedByWord;

    public DoThis(List<String> urls, String seekWord) {
        this.urls = urls;
        this.seekWord = seekWord;
    }

    public void setSeekWord(String seekWord) {
        this.seekWord = seekWord;
        this.sortedByWord = DoMap.getSortedMap(sortedByWord, seekWord);
    }

    public Map<String, Map<String, Integer>> sorted() {
        return sortedByWord;
    }

    public void doRun() {
        Map<String, Map<String, Integer>> urlWordsFrequencyMap = new HashMap<>();

        DoMap.goByURLs(urls, urlWordsFrequencyMap, MAX);

        System.out.println("Sort!!!");

        /*Получаем соритрованный по частоте слова map*/
        this.sortedByWord = DoMap.getSortedMap(urlWordsFrequencyMap, seekWord);

        print();
    }

    public void print(){
          /*Выводим сртированный map*/
        for (Map.Entry<String, Map<String, Integer>> entry : this.sortedByWord.entrySet()) {
            Integer count = entry.getValue().get(seekWord);
            System.out.println(entry.getKey() + "\n" + entry.getValue());
            System.out.println(seekWord + " number: " + (count == null ? 0 : count));
        }
    }
}
