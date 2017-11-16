package homeWorks.hw4.geometry.childrens.grandchildrens;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTriangleTest {
    int c1 = 0;
    int c2 = -34;
    int c3 = 123;

    @Test
    public void isValid() throws Exception {
        assertTrue(ColorTriangle.isValid(c1));
        assertFalse(ColorTriangle.isValid(c2));
        assertTrue(ColorTriangle.isValid(c3));
    }
}