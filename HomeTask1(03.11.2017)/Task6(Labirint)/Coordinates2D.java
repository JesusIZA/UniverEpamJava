package epam.hw1.tasc6labirint;

/**
 * @author Jesus Raichuk
 */
public class Coordinates2D {
    private int y;
    private int x;

    public Coordinates2D() {
        this.y = 0;
        this.x = 0;
    }

    public Coordinates2D(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int Y() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int X() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setCoordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int[] getCoordinate(){
        int[] coordinate = {Y(), X()};
        return coordinate;
    }

    @Override
    public String toString() {
        return "[" + y + "," + x + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates2D that = (Coordinates2D) o;

        if (y != that.y) return false;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }
}
