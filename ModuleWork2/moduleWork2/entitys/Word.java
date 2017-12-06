package moduleWork2.entitys;

/**
 * Class realized word that can contain min one letter
 *
 * @author Jesus Raichuk
 */
public class Word {
    /**
     * Word text
     */
    private String word;

    public Word(String word) {
        this.word = word.toLowerCase();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word.toLowerCase();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word != null ? word.equals(word1.word) : word1.word == null;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
