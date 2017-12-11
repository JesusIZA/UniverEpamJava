package homeWorks.hw7.task1.entitys;

/**
 * Class realized Wini
 *
 * @author Jesus Raichuk
 */
public class Wini {
    /**
     * Variable visualize is Wini found Bees or not
     */
    private static boolean found = false;

    public Wini() {
        found = false;
    }

    public synchronized static boolean isFound() {
        return found;
    }

    public synchronized static void setFound(boolean found) {
        Wini.found = found;
    }
}
