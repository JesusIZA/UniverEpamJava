package homeWork.hw8.etitys;

/**
 * Class realized Airline
 *
 * @author Jesus Raichuk
 */
public class Airline {
    /**
     * Airline ID
     */
    private int id;
    /**
     * Airline name
     */
    private String aName;

    public Airline() {
    }

    public Airline(int id, String name) {
        this.id = id;
        this.aName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return aName;
    }

    public void setName(String name) {
        this.aName = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", aName='" + aName + '\'' +
                '}';
    }
}
