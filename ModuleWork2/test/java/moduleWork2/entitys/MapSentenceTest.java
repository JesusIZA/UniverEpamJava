package moduleWork2.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MapSentenceTest {
    Sentence sent;
    MapSentence mSent;

    @Before
    public void setUp(){
        sent = new Sentence("the the not it is");
        mSent = new MapSentence(sent);
    }

    @After
    public void tearDown(){
        sent = null;
        mSent = null;
    }

    @Test
    public void findWordCount() throws Exception {
        int act = mSent.findWordCount("the");
        int exp = 2;

        assertTrue(act == exp);

        List words = Arrays.asList(new Word("hi"), new Word("no"), new Word("hi"));
        Sentence sent2= new Sentence(words);
        MapSentence mS2 = new MapSentence(sent2);

        int act2 = mS2.findWordCount("hi");
        int exp2 = 2;

        assertTrue(act2 == exp2);

        int act3 = mS2.findWordCount("by");
        int exp3 = 0;

        assertTrue(act3 == exp3);

        Map<String, Integer> map = new HashMap<String ,Integer>();
        map.put("no", 11);
        map.put("yes", 33);

        mS2.setWords(map);

        int act4 = mS2.findWordCount("Yes");
        int exp4 = 33;

        assertTrue(act4 == exp4);

        assertTrue(map.equals(mS2.getWords()));
    }

}