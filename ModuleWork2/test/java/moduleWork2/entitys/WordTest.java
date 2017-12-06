package moduleWork2.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {
    Word w;

    @Before
    public void setUp() throws Exception {
        w = new Word("The");
    }

    @After
    public void tearDown() throws Exception {
        w = null;
    }

    @Test
    public  void startTest() throws Exception {
        String act = w.getWord();
        String exp = "the";

        assertTrue(act.equals(exp));

        w.setWord("Hi");

        String act2 = w.getWord();
        String exp2 = "hi";

        assertTrue(act2.equals(exp2));

        Word w1 = new Word("No");
        Word w2 = new Word("no");

        assertTrue(w1.equals(w2));

        String act3 = w.getWord();
        String exp3 = w.toString();

        assertTrue(act3.equals(exp3));
    }


}