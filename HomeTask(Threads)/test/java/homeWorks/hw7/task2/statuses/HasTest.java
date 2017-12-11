package homeWorks.hw7.task2.statuses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HasTest {
    Has h;
    @Before
    public void setUp() throws Exception {
        h = new Has();
    }

    @After
    public void tearDown() throws Exception {
        h = null;
    }

    @Test
    public void count() throws Exception {
        h.isInto = false;
        h.into(20);
        int exp = 20;
        int act = h.count();

        assertEquals(exp, act);
    }

    @Test
    public void into() throws Exception {
        h.isInto = false;
        h.into(10);

        assertTrue(h.n == 10);
    }

}