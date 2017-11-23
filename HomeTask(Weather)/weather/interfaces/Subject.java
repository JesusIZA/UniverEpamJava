package homeWorks.weather.interfaces;

/**
 * Observer subject
 *
 * @author Jesus Raichuk
 */
public interface Subject {
    /**
     * Method register new client
     * @param obs - client
     */
    public void registerObserver(Observer obs);

    /**
     * Method remove client
     * @param obs - client
     */
    public void removeObserver(Observer obs);

    /**
     * Method send clients about changes of the weather
     */
    public void notifyObservers();
}
