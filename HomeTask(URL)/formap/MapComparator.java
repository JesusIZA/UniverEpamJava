package homeWorks.url.formap;

import java.util.Comparator;
import java.util.Map;

/**
 * Comparator for map of word
 *
 * @author Jesus Raichuk
 */
public class MapComparator implements Comparator<Map<String, Integer>> {
    private String word;

    public MapComparator(String word) {
        this.word = word;
    }
    /**
     * Compare number of words in two map
     * @param map1 - first map
     * @param map2 - second map
     * @return - sub of these numbers
     */
    @Override
    public int compare(Map<String, Integer> map1, Map<String, Integer> map2) {
        int one = getMap(map1, word);
        int two = getMap(map2, word);

        return one - two;
    }

    /**
     * Get number of word in the map
     * @param map - map will be for look
     * @param word - look for one
     * @return int - how much
     */
    private int getMap(Map<String, Integer> map, String word) {
        if (map.containsKey(word))
            return map.get(word);
        return 0;
    }
}
