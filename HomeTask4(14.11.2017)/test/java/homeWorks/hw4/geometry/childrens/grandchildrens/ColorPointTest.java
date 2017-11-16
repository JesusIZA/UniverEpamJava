package homeWorks.hw4.geometry.childrens.grandchildrens;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorPointTest {
    int c1 = 0;
    int c2 = -34;
    int c3 = 123;

    @Test
    public void isValid() throws Exception {
        assertTrue(ColorPoint.isValid(c1));
        assertFalse(ColorPoint.isValid(c2));
        assertTrue(ColorPoint.isValid(c3));
    }
}