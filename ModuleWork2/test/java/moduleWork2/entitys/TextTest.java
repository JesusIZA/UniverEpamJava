package moduleWork2.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TextTest {
    Text t;

    @Before
    public void setUp() throws Exception {
        t = new Text("Hi mam! I am at home. Where are father");
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public  void startTest() throws Exception {
        int act = t.getSentences().size();
        int exp = 3;

        assertTrue(act == exp);

        List<Sentence> sents = Arrays.asList(new Sentence("Hi mam!"), new Sentence("Hi dad!"), new Sentence("Yes it is true."));
        t.setSentences(sents);

        int act2 = t.getSentences().size();
        int exp2 = 3;

        assertTrue(act2 == exp2);

        t = new Text(sents);

        int act3 = t.getSentences().size();
        int exp3 = 3;

        assertTrue(act3 == exp3);
    }

}