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
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
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
