package homeWorks.hw4.geometry.childrens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for class Line
 */
public class LineTest {
    Point p1;
    Point p2;
    Point p3;
    Line l1;
    @Before
    public void init() {
        p1 = new Point(1,2);
        p2 = new Point(1, 5);
        p3 = new Point(1, 5);
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
        int exp = 3;
        int act = l1.getLength();
        assertEquals(exp, act);
    }
    @Test
    public void isValid() throws Exception {
        assertTrue(Line.isValid(p1, p2));
        assertFalse(Line.isValid(p2, p3));
    }
    @Test
    public void setBeg() throws Exception {
        l1.setBeg(p2);
        Point exp = p1;
        Point act = l1.getBeg();
        assertEquals(exp, act);
    }
    @Test
    public void setEnd() throws Exception {
        l1.setEnd(p1);
        Point exp = p2;
        Point act = l1.getEnd();
        assertEquals(exp, act);
    }
}
