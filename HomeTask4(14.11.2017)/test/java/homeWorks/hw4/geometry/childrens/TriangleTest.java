package homeWorks.hw4.geometry.childrens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for Triangle
 */
public class TriangleTest {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    Triangle tr;

    @Before
    public void init() {
        p1 = new Point(1,2);
        p2 = new Point(1, 5);
        p3 = new Point(5,5);
        p4 = new Point(1,5);
        tr = new Triangle(p1, p2, p3);
    }
    @After
    public void tearDown() {
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        tr = null;
    }

    @Test
    public void isValid() {
        assertTrue(Triangle.isValid(p1, p2, p3));
        assertFalse(Triangle.isValid(p1, p2, p4));
        assertFalse(Triangle.isValid(p1, p1, p1));
        assertFalse(Triangle.isValid(p2, p3, p4));
    }

    @Test
    public void getPerimeter(){
        assertEquals(tr.getPerimeter(), 12);
    }

    @Test
    public void getArea(){
        assertEquals(tr.getArea(), 6);
    }

}
