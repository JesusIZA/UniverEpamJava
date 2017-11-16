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
        return "ColorTriangle{" +
                "color = " + color +
                ", apexA = " + getApexA() +
                ", apexB = " + getApexB() +
                ", apexC = " + getApexC() +
                '}';
    }
}
