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
        if(isValid(points)) this.poly = points;
    }

    public Point[] getPoly() {
        return poly;
    }

    public void setPoly(Point[] poly) {
        if(isValid(poly))
        this.poly = poly;
    }

    @Override
    public String toString() {
        return getName() + " {" +
                "poly = " + Arrays.toString(poly) +
                '}';
    }
    /**
     * Checking the entered points for validity by polygon
     * @param points - entered points
     * @return boolean value - can this points be apexes of one polygon
     */
    public static boolean isValid(Point[] points){
        //If it is triangle, line or point
        if (points.length < 4) return false;
        //If it contain equals points
        for (int  i = 0; i < points.length - 1; i++){
            if(points[i].equals(points[i + 1])) return false;
        }
        //If it is line
        int counterX = 0, counterY = 0;
        for (int i = 0; i < points.length - 1; i++) {
            if(points[i].getX() == points[i + 1].getX()) counterX++;
            if(points[i].getY() == points[i + 1].getY()) counterY++;
        }
        if (counterX == points.length - 1 || counterY == points.length - 1) return false;
        //If all tests are good
        return true;
    }
}
