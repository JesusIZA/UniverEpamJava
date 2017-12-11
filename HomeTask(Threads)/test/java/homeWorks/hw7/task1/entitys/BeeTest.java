package homeWorks.hw7.task1.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BeeTest {
    List<Integer> square;
    Wini w;
    @Before
    public void setUp() throws Exception {
        square = Arrays.asList(1,0,0);
        w = new Wini();
    }

    @After
    public void tearDown() throws Exception {
        square = null;
        w = null;
    }

    @Test
    public void run() throws Exception {
        Bee b = new Bee(w);
        b.setSquare(square);

        b.run();

        assertTrue(w.isFound());
    }

}