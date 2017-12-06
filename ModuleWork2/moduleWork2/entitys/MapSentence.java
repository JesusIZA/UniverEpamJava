package moduleWork2.entitys;

import java.util.HashMap;
import java.util.Map;

/**
 * Class realized map of sentence
 * It is Class pseudo decorator for class Sentence
 * It need for count how much each words is in the sentence and get it
 *
 * @author Jesus Raichuk
 */
public class MapSentence {
    /**
     * List of words with number of occurrences each
     */
    Map<String, Integer> words;

    /**
     * Constructor - decorator
     * Take some simple sentence and change it for map type
     * @param sent - sentence will processed
     */
    public MapSentence(Sentence sent) {
        words = new HashMap<String, Integer>();
        for (int i = 0; i < sent.getWords().size(); i++) {
            String word = sent.getWords().get(i).getWord();
            int tempInt = 0;
            for (int j = 0; j < sent.getWords().size(); j++) {
                if(word.equals(sent.getWords().get(j).getWord())) ++tempInt;
            }
            words.put(word, tempInt);
        }
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    /**
     * Get number of occurrences word we need
     * @param word - word we need to know number of occurrences
     * @return int - number of occurrences of word
     */
    public int findWordCount(String word){
        try {
            return words.get(word.toLowerCase()).intValue();
        } catch (NullPointerException e){
            return 0;
        }
    }

    /**
     * Print the word
     */
    public void print() {
        System.out.println(words);
    }
}
