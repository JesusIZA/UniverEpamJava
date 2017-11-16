package homeWorks.hw4.geometry.childrens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for class Line
 */
public class LineTest {
    Point p1;
    Point p2;
    Line l1;
    @Before
    public void init() {
        p1 = new Point(1,2);
        p2 = new Point(1, 5);
        l1 = new Line(p1, p2);
    }
    @After
    public void tearDown() {
        p1 = null;
        p2 = null;
        l1 = null;
    }
    @Test
    public void getLength() throws Exception {
        assertEquals(l1.getLength(), 3);
    }
}
