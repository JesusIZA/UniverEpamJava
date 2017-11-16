package homeWorks.hw4.geometry.childrens.grandchildrens;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorLineTest {
    int c1 = 0;
    int c2 = -34;
    int c3 = 123;

    @Test
    public void isValid() throws Exception {
        assertTrue(ColorLine.isValid(c1));
        assertFalse(ColorLine.isValid(c2));
        assertTrue(ColorLine.isValid(c3));
    }
}