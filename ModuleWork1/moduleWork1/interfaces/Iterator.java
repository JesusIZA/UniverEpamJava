package moduleWork1.interfaces;

/**
 * Interface for realize Iterator pattern
 *
 * @author Jesus Raichuk
 */
public interface Iterator {
    /**
     * Return false if list hasn't next item and true if has next
     * @return - the presence of one more
     */
    public boolean hasNext();

    /**
     * Get next item of the list
     * @return - next item
     */
    public Object next();
}
