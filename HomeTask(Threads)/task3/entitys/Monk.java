package homeWorks.hw7.task3.entitys;

/**
 * Monk will fight
 *
 * @author Jesus Raichuk
 */
public class Monk {
    /**
     * Name of the monk
     */
    private String name;
    /**
     * Power of the monk
     */
    private int power;

    public Monk(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "[" + name + " = " + power + "]";
    }
}
