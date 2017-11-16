package homeWorks.hw4.geometry.childrens.grandchildrens;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorPolygonTest {
    int c1 = 0;
    int c2 = -34;
    int c3 = 123;

    @Test
    public void isValid() throws Exception {
        assertTrue(ColorPolygon.isValid(c1));
        assertFalse(ColorPolygon.isValid(c2));
        assertTrue(ColorPolygon.isValid(c3));
    }
}