package homeWorks.hw4.geometry.childrens;

import homeWorks.hw4.geometry.Geometry;
/**
 * Class that realized Geometric Point
 *
 * @author Jesus Raichuk
 */
public class Point extends Geometry implements Cloneable{
    /**
     * X coordinate
     */
    private int x;
    /**
     * Y coordinate
     */
    private int y;

    public Point(int x, int y) {
        super("Point");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    protected Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return getName() + " [x = " + x + ", y = " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}