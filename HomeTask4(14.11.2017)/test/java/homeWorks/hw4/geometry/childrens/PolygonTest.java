package homeWorks.hw4.geometry.childrens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonTest {
    Point[] points1;
    Point[] points2;
    Point[] points3;
    Point[] points4;
    Point[] points5;
    @Before
    public void init() {
        points1 = new Point[]{
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2)};
        points2 = new Point[]{
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2)};
        points3 = new Point[]{
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(4, 2),
                new Point(5, 2)};
        points4 = new Point[]{
                new Point(1, 1),
                new Point(1, 2),
                new Point(1, 3),
                new Point(1, 4),
                new Point(1, 5)};
        points5 = new Point[]{
                new Point(1, 1),
                new Point(6, 2),
                new Point(7, 3),
                new Point(1, 4),
                new Point(4, 5)};
    }
    @After
    public void tearDown() {
        points1 = null;
        points2 = null;
        points3 = null;
        points4 = null;
        points5 = null;
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(Polygon.isValid(points5));
        assertFalse(Polygon.isValid(points1));
        assertFalse(Polygon.isValid(points2));
        assertFalse(Polygon.isValid(points3));
        assertFalse(Polygon.isValid(points4));
    }


}
