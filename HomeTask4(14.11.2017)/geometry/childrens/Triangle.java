package homeWorks.hw4.geometry.childrens;

import homeWorks.hw4.geometry.Geometry;

/**
 * Class that realized Geometric Triangle
 *
 * @author Jesus Raichuk
 */
public class Triangle extends Geometry{
    /**
     * Apexes of triangle
     */
    private Point apexA, apexB, apexC;
    /**
     * Sides of triangle
     */
    private Line sideAB, sideBC, sideAC;

    public Triangle(Point apexA, Point apexB, Point apexC){
        super("Triangle");
        if(isValid(apexA, apexB, apexC)) {
            this.apexA = apexA;
            this.apexB = apexB;
            this.apexC = apexC;
        }
    }

    public Line getSideAB() {
        if (sideAB == null) sideAB = new Line(apexA, apexB);
        return sideAB;
    }

    public Line getSideBC() {
        if (sideBC == null) sideBC = new Line(apexB, apexC);
        return sideBC;
    }

    public Line getSideAC() {
        if (sideAC == null) sideAC = new Line(apexA, apexC);
        return sideAC;
    }

    public void setApexA(Point p){
        if(isValid(p, apexB, apexC)) {
            apexA = p;
            sideAB = null;
            sideAC = null;
        }
    }

    public void setApexB(Point p){
        if(isValid(apexA, p, apexC)) {
            apexB = p;
            sideAB = null;
            sideBC = null;
        }
    }

    public void setApexC(Point p){
        if(isValid(apexA, apexB, p)) {
            apexC = p;
            sideBC = null;
            sideAC = null;
        }
    }

    public Point getApexA() {
        return apexA;
    }

    public Point getApexB() {
        return apexB;
    }

    public Point getApexC() {
        return apexC;
    }

    /**
     * Checking the entered points for validity by triangle
     * @param p1 - first point
     * @param p2 - second point
     * @param p3 - third point
     * @return boolean value - can this points be apexes of one triangle or not
     */
    public static boolean isValid(Point p1, Point p2, Point p3){
        if(p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) return false;
        else {
            if(p1.getX() == p2.getX() && p1.getX() == p3.getX()) return false;
            else if(p1.getY() == p2.getY() && p1.getY() == p3.getY()) return false;
            else return true;
        }
    }
    /**
     * Get array of sides lengths of the triangle
     * @return new double[] - array of sides
     */
    private int[] getSides (){
        int aL = 0, bL = 0, cL = 0;
        aL = (int)Math.sqrt((apexB.getX() - apexA.getX())*(apexB.getX() - apexA.getX()) +
                (apexB.getY() - apexA.getY())*(apexB.getY() - apexA.getY()));
        bL = (int)Math.sqrt((apexC.getX() - apexB.getX())*(apexC.getX() - apexB.getX()) +
                (apexC.getY() - apexB.getY())*(apexC.getY() - apexB.getY()));
        cL = (int)Math.sqrt((apexA.getX() - apexC.getX())*(apexA.getX() - apexC.getX()) +
                (apexA.getY() - apexC.getY())*(apexA.getY() - apexC.getY()));
        return new int[]{aL, bL, cL};
    }
    /**
     * Get perimeter of the triangle
     * @return - perimeter
     */
    public int getPerimeter(){
        int[] sides = getSides();
        return sides[0] + sides[1] + sides[2];
    }
    /**
     * Get area of the triangle
     * @return - area
     */
    public int getArea(){
        int[] sides = getSides();
        int p = getPerimeter() / 2;
        return (int)Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    @Override
    public String toString() {
        return getName() + " {" +
                "apexA = " + apexA +
                ", apexB = " + apexB +
                ", apexC = " + apexC +
                '}';
    }
}