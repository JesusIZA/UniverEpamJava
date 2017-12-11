package homeWorks.hw7.task4.entitys;

/**
 * Place for car staying
 *
 * @author Jesus Raichuk
 */
public class Place {
    /**
     * Id the place
     */
    public int id;
    /**
     * Is here some car or not
     */
    public boolean use = false;

    public Place(int id) {
        this.id = id;
    }
}
