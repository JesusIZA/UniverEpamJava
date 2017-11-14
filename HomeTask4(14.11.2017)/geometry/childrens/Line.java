package homeWorks.hw4.geometry.childrens;

import homeWorks.hw4.geometry.Geometry;
/**
 * Class that realized Geometric Line
 *
 * @author Jesus Raichuk
 */
public class Line extends Geometry{
    /**
     * Start of Line
     */
    private Point beg;
    /**
     * End of line
     */
    private Point end;

    public Line(Point beg, Point end) {
        super("Line");
        this.beg = beg;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        super("Line");
        this.beg = new Point(x1,y1);
        this.end = new Point(x2,y2);
    }

    public Point getBeg() {
        //return new Point(beg);
        return beg;
    }

    public void setBeg(Point beg) {
        this.beg = beg;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return getName() +  " {" +
                "beg = " + beg +
                ", end = " + end +
                '}';
    }
}