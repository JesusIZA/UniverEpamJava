package moduleWork2.entitys;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class realized sentence that can be empty and after we can add word to one
 *
 * @author Jesus Raichuk
 */
public class Sentence {
    /**
     * List of words in Sentence
     */
    private List<Word> words;

    /**
     * Constructor
     * Take some text (String type) and cut this on words
     * After create these words and put them into the list
     * @param sent - text will cut on words and put into the list
     */
    public Sentence(String sent) {
        words = new LinkedList<Word>();
        Pattern p1 = Pattern.compile("\\w+");
        Matcher m1 = p1.matcher(sent.toLowerCase());
        while (m1.find()) {
            words.add(new Word(m1.group()));
        }
    }

    public Sentence(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    /**
     * Check text (String type) can it be sentence or not
     * @param sent - text will check
     * @return boolean - con be sentence or not
     */
    public static boolean haveWords(String sent){
        Pattern p1 = Pattern.compile("\\w+");
        Matcher m1 = p1.matcher(sent);
        if (m1.find()) return true;
        return false;
    }

    /**
     * Print list of words (print sentence)
     */
    public void print() {
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i).toString());
            System.out.print(" ");
        }
    }
}
