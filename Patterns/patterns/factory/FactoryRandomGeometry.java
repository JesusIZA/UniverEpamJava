package patterns.factory;

import homeWorks.hw4.geometry.Geometry;
import homeWorks.hw4.geometry.childrens.Line;
import homeWorks.hw4.geometry.childrens.Point;
import homeWorks.hw4.geometry.childrens.Polygon;
import homeWorks.hw4.geometry.childrens.Triangle;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorLine;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorPoint;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorPolygon;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorTriangle;

import java.util.Random;

/**
 * Class abstract Geometric figures factory
 *
 * @author Jesus Raichuk
 */
public abstract class FactoryRandomGeometry {
    /**
     * Get random Geometric figure
     * @return nextGeometry - geometry figure
     */
    public static Geometry getRandom() {
        Random r = new  Random();
        return nextGeometry(r.nextInt(8));
    }

    /**
     * Return Geometric figure that it need with random parameters
     * @param i - index of figure it need to create
     * @return new Geometry - geometry with random parameters
     */
    private static Geometry nextGeometry(int i) {
        Random r = new  Random();
        switch (i){
            case 0: return new Point(
                    r.nextInt(100), r.nextInt(100));
            case 1: return new Line(
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)));
            case 2: return new Triangle(
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)));
            case 3: return new Polygon(
                    new Point[]{
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100)),
                    new Point(r.nextInt(100), r.nextInt(100))});
            case 4: return new ColorPoint(
                    r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900));
            case 5: return new ColorLine(new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    100 + r.nextInt(900));
            case 6: return new ColorTriangle(new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    100 + r.nextInt(900));
            case 7: return new ColorPolygon(new ColorPoint[]{
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900)),
                    new ColorPoint(r.nextInt(100), r.nextInt(100), 100 + r.nextInt(900))
                    },100 + r.nextInt(900));
            default: return null;
        }
    }

    ;
}
