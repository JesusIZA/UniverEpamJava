package homeWorks.hw4.geometry.childrens.grandchildrens;

import homeWorks.hw4.geometry.childrens.Line;
import homeWorks.hw4.geometry.childrens.Point;
import homeWorks.hw4.interfaces.ColorAble;

/**
 * Class that realized Geometric Line has color
 *
 * @author Jesus Raichuk
 */
public class ColorLine extends Line  implements ColorAble {
    /**
     * Line color
     */
    private int color;

    public ColorLine(Point beg, Point end, int color) {
        super(beg, end);
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
        return "ColorLine [color = " + color + ", beg = " + getBeg() + ", end = " + getEnd() + "]";
    }

}
