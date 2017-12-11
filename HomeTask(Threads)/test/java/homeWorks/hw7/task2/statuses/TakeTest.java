package homeWorks.hw7.task2.statuses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TakeTest {
    Take t;
    @Before
    public void setUp() throws Exception {
        t = new Take();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void take() throws Exception {
        t.isPut = false;
        t.put(20);
        int exp = 20;
        int act = t.take();

        assertEquals(exp, act);
    }

    @Test
    public void put() throws Exception {
        t.isPut = false;
        t.put(10);

        assertTrue(t.n == 10);
    }

}