package homeWorks.url.formap;

import homeWorks.url.forsite.SiteWorker;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class processor for map
 *
 * @author Jesus Raichuk
 */
public class DoMap {
    /**
     * Sort the map by word
     * @param map - map will process
     * @param word - word for sorting
     * @return map - sorted
     */
    public static Map<String, Map<String, Integer>> getSortedMap(Map<String, Map<String, Integer>> map, String word) {
        MapComparator comparator = new MapComparator(word);
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    /**
     * Search URLs for words we need
     * @param urlWordsMap - word and number of one
     * @param numbers now many urls we need
     */
    public static void goByURLs(List<String> urls, Map<String, Map<String, Integer>> urlWordsMap, byte numbers) {
        for (int i = 0; i < urls.size() && urlWordsMap.size() <= numbers; i++) {
            String url = urls.get(i);
            try {
                String text = new SiteWorker(url).getText();

                Map<String, Integer> words = new HashMap<>();
                fillMap(words, text);

                if (words.size() > 0) {
                    System.out.println(url);

                    if (!urlWordsMap.containsKey(url)) {
                        urlWordsMap.put(url, words);
                    } else {
                        System.err.println(url + " contained!");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * Fill the map words from the text
     * @param map - map will fill
     * @param text - text will read
     */
    public static void fillMap(Map<String, Integer> map, String text) {
        String[] words = text.split("[\\W\\d]");
        int wordsMinLength = 3;
        for (String word : words) {
            if (word.length() >= wordsMinLength) {
                Integer freq = map.get(word);
                map.put(word, (freq == null) ? 1 : freq + 1);
            }
        }
    }
}
