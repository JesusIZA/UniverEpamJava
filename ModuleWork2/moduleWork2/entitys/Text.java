package moduleWork2.entitys;

import java.util.LinkedList;
import java.util.List;
/**
 * Class realized text that can be empty and after we can add sentences to one
 *
 * @author Jesus Raichuk
 */
public class Text {
    /**
     * List of sentences
     */
    private List<Sentence> sentences;

    /**
     * Constructor
     * Take some text (String type) and cut this on sentences
     * After check this part of text can it be sentence or not
     * If can - create these sentences and put them into the list
     * @param text - text will cut on sentences and put into the list
     */
    public Text(String text) {
        sentences = new LinkedList<Sentence>();
        String[] temp = text.toLowerCase().split("[.]|[?]|!");
        for (int i = 0; i < temp.length; i++) {
            //Check for valid string
            if(Sentence.haveWords(temp[i]))
                sentences.add(new Sentence(temp[i]));
        }
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    /**
     * Print List of sentence (print text)
     */
    public void print() {
        for (int i = 0; i < sentences.size(); i++) {
            sentences.get(i).print();
            System.out.println();
        }
    }
}
