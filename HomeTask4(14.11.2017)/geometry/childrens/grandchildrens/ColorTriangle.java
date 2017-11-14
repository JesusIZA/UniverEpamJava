package homeWorks.hw4.geometry.childrens.grandchildrens;

import homeWorks.hw4.geometry.childrens.Point;
import homeWorks.hw4.geometry.childrens.Triangle;
import homeWorks.hw4.interfaces.ColorAble;
/**
 * Class that realized Geometric Triangle has color
 *
 * @author Jesus Raichuk
 */
public class ColorTriangle extends Triangle implements ColorAble {
    /**
     * Triangle color
     */
    private int color;

    public ColorTriangle(Point apexA, Point apexB, Point apexC, int color) {
        super(apexA, apexB, apexC);
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
        return "ColorTriangle{" +
                "color = " + color +
                ", apexA = " + getApexA() +
                ", apexB = " + getApexB() +
                ", apexC = " + getApexC() +
                '}';
    }
}
