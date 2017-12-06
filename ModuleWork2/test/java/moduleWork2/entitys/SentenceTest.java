package moduleWork2.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SentenceTest {

    @Test
    public void haveWords() throws Exception {
        assertTrue(Sentence.haveWords("A"));
        assertTrue(Sentence.haveWords("5"));
        assertTrue(Sentence.haveWords("The"));
        assertTrue(Sentence.haveWords("How are you?"));
        assertTrue(Sentence.haveWords("one two"));
        assertTrue(Sentence.haveWords("/No yes/"));

        assertFalse(Sentence.haveWords(""));
        assertFalse(Sentence.haveWords("/"));
        assertFalse(Sentence.haveWords("))"));
        assertFalse(Sentence.haveWords("#%)--"));

    }

    @Test
    public void setWordsByLower() {
        Sentence sent = new Sentence("No yes.");

        sent.setWords(Arrays.asList(new Word("Yeah"), new Word("45"), new Word("noK")));

        String exp = "yeah";
        String act = sent.getWords().get(0).getWord();

        assertEquals(exp, act);

        String exp2 = "45";
        String act2 = sent.getWords().get(1).getWord();

        assertEquals(exp2, act2);

        String exp3 = "nok";
        String act3 = sent.getWords().get(2).getWord();

        assertEquals(exp3, act3);
    }

}