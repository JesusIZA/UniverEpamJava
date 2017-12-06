package homeWorks.hw4.geometry;

import java.io.Serializable;

/**
 * Class Geometry
 * Class that realized geometry figure has name
 *
 * @author Jesus Raichuk
 */
public class Geometry implements Serializable{
    /**
     * Name of geometry figure
     */
    String name;

    public Geometry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "name = '" + name + '\'' +
                '}';
    }
}
