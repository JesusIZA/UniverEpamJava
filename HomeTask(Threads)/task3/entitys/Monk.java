package homeWorks.hw7.task3.entitys;

/**
 * @author Jesus Raichuk
 */
public class Monk {
    private String name;
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
        return "Monk{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
