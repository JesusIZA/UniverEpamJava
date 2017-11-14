package homeWorks.hw4.geometry.childrens;

import homeWorks.hw4.geometry.Geometry;

import java.util.Arrays;
/**
 * Class that realized Geometric Polygon
 *
 * @author Jesus Raichuk
 */
public class Polygon extends Geometry{
    /**
     * Apexes array
     */
    private Point[] poly;

    public Polygon(Point[] points){
        super("Polygon");
        this.poly = points;
    }

    public Point[] getPoly() {
        return poly;
    }

    public void setPoly(Point[] poly) {
        this.poly = poly;
    }

    @Override
    public String toString() {
        return getName() + " {" +
                "poly = " + Arrays.toString(poly) +
                '}';
    }
}
