package homeWorks.hw4.geometry.childrens.grandchildrens;

import homeWorks.hw4.geometry.childrens.Point;
import homeWorks.hw4.geometry.childrens.Polygon;
import homeWorks.hw4.interfaces.ColorAble;

import java.util.Arrays;

/**
 * Class that realized Geometric Polygon has color
 *
 * @author Jesus Raichuk
 */
public class ColorPolygon extends Polygon  implements ColorAble {
    /**
     * Polygon color
     */
    private int color;

    public ColorPolygon(Point[] points, int color) {
        super(points);
        if(isValid(color))
        this.color = color;
    }
    /**
     * Checking the entered int value for validity by color
     * @param color - int value will check
     * @return boolean value - can this int value be color or not
     */
    public static boolean isValid(int color){
        if(color >= 0) return true;
        else return false;
    }
    @Override
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        if(isValid(color))
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorPolygon{" +
                "color = " + color +
                ", poly = " + Arrays.toString(getPoly()) +
                '}';
    }
}
