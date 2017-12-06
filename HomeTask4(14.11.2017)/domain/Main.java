package homeWorks.hw4.domain;

import homeWorks.hw4.abstracts.RandomGeometry;
import homeWorks.hw4.geometry.Geometry;
import homeWorks.hw4.geometry.childrens.Line;
import homeWorks.hw4.geometry.childrens.Point;
import homeWorks.hw4.geometry.childrens.Polygon;
import homeWorks.hw4.geometry.childrens.Triangle;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorLine;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorPoint;
import homeWorks.hw4.geometry.childrens.grandchildrens.ColorTriangle;
import homeWorks.hw4.interfaces.ColorAble;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. создать последовательность из фигур  используя фабрику цветных и нецветных фигур
 * 2. получить масивы цветных и не цветных и сколько каждых фигур в нем присутсвует
 * 3. групируем в масивах фигуры
 *
 * @author Jesus Raichuk
 */
public class Main {
    /**
     * Quantity of Geometric figures will created and processed
     */
    static final int N = 10;
    static List geometries = new LinkedList<Geometry>();
    static final String S_FILE = "test.txt";

    public static void main(String[] args) {
        /**
         * Fill random value
         */
        for (int i = 0; i < N; i++) {
            geometries.add(RandomGeometry.getRandom());
        }

        printList(geometries);

        /**
         * List Geometric figures that are color able
         */
        List colorAbles = new ArrayList<Geometry>();
        /**
         * List Geometric figures that aren't color able
         */
        List simpleGeoms = new ArrayList<Geometry>();
        /**
         * Counter for not color able Points
         */
        int simplePoints = 0;
        /**
         * Counter for not color able Lines
         */
        int simpleLines = 0;
        /**
         * Counter for not color able Triangles
         */
        int simpleTriangles = 0;
        /**
         * Counter for not color able Polygons
         */
        int simplePolygons = 0;
        /**
         * Counter for color able Points
         */
        int colorPoints = 0;
        /**
         * Counter for color able Lines
         */
        int colorLines = 0;
        /**
         * Counter for color able Triangles
         */
        int colorTriangles = 0;
        /**
         * Counter for color able Polygons
         */
        int colorPolygons = 0;
        /**
         * Counting each types of Geometric figures and divide by color able and not
         */
        for (int i = 0; i < geometries.size(); i++) {
            if(geometries.get(i) instanceof ColorAble) {
                colorAbles.add(geometries.get(i));
                if(geometries.get(i) instanceof ColorPoint){
                    simplePoints++;
                } else if(geometries.get(i) instanceof ColorLine) {
                    simpleLines++;
                } else if(geometries.get(i) instanceof ColorTriangle) {
                    simpleTriangles++;
                } else {
                    simplePolygons++;
                }
            } else {
                simpleGeoms.add(geometries.get(i));
                if(geometries.get(i) instanceof Point){
                    colorPoints++;
                } else if(geometries.get(i) instanceof Line) {
                    colorLines++;
                } else if(geometries.get(i) instanceof Triangle) {
                    colorTriangles++;
                } else {
                    colorPolygons++;
                }
            }
        }

        System.out.println("\nSimple Geoms:");
        printList(simpleGeoms);

        System.out.println("Color Ables:");
        printList(colorAbles);

        System.out.println("Simple Points: " + simplePoints);
        System.out.println("Simple Lines: " + simpleLines);
        System.out.println("Simple Triangles: " + simpleTriangles);
        System.out.println("Simple Polygons: " + simplePolygons);
        System.out.println("Color Points: " + colorPoints);
        System.out.println("Color Lines: " + colorLines);
        System.out.println("Color Triangles: " + colorTriangles);
        System.out.println("Color Polygons: " + colorPolygons);

        //Sorting
        System.out.println("\nSorted Simple Geoms:");
        sortingList(simpleGeoms);
        printList(simpleGeoms);

        System.out.println("Sorted Color Ables:");
        sortingList(colorAbles);
        printList(colorAbles);

        System.out.println("*************************************************\nBefore Serialization:");
        printList(geometries);
        //Serialization
        serializeList(geometries, S_FILE);
        //Deserialization
        List geometries2 = deserializeList(S_FILE);
        System.out.println("After Serialization:");
        printList(geometries2);

    }
    /**
     * Print list will received
     * @param list - list will printed
     */
    public static void printList(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Sort the list of Geometric figures
     * @param list - list will sort
     */
    public static void sortingList(List<Geometry> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if(list.get(j) instanceof Point && j > 0){
                    Geometry temp = list.get(j);
                    list.remove(j);
                    list.add(j - 1, temp);
                } else if(list.get(j) instanceof Polygon && j < list.size() - 1){
                    Geometry temp = list.get(j);
                    list.remove(j);
                    list.add(j + 1, temp);
                } else if((list.get(j) instanceof Line && j > 0) &&
                        (list.get(j - 1) instanceof Triangle || list.get(j - 1) instanceof Polygon)){
                    Geometry temp = list.get(j);
                    list.remove(j);
                    list.add(j - 1, temp);
                }
            }
        }

    }

    /**
     * Take list of Geometric figures and serialized them (put into file we need)
     * @param lg - list of Geometric figures will serialized
     * @param f_name - file will put the list
     */
    public static void serializeList(List<Geometry> lg , String f_name) {
        try {
            FileOutputStream fos = new FileOutputStream(f_name);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(lg); os.close();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    /**
     * Get list of Geometric figures from file (deserialize list)
     * And return deserialize list of Geometric figures
     * @param f_name - file will reading
     * @return List - list with Geometric figures were deserialize
     */
    public static List<Geometry> deserializeList(String f_name) {
        List<Geometry> lg = null;
        try {
            FileInputStream fis = new FileInputStream(f_name);
            ObjectInputStream is = new ObjectInputStream(fis);
            lg = (List<Geometry>) is.readObject();
            is.close();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return lg;
    }

}
