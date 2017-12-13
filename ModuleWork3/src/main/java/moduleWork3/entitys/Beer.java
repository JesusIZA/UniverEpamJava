package moduleWork3.entitys;

import moduleWork3.exceptions.TypeException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class realized Beer
 *
 * @author Jesus Raichuk
 */
public class Beer {
    /**
     * Id of the beer
     */
    private String id = "0";
    /**
     * Name of the beer
     */
    private String name = "noName";
    /**
     * Type of the beer
     */
    private String type = "noType";
    /**
     * Is alcoholic or not of the beer
     */
    private boolean al = false;
    /**
     * Manufacturer of the beer
     */
    private String manufacturer = "noManufacturer";
    /**
     * List of ingredients of the beer
     */
    private List<String> ingredients = new ArrayList<String>();
    /**
     * Chars of the beer
     */
    private Chars crs = new Chars();
    /**
     * Loger
     */
    private static Logger logger = Logger.getLogger(Beer.class);

    public Beer() {
    }

    public Beer(String id, String name, String type, boolean al, String manufacturer, List<String> ingredients, Chars crs) {
        this.setId(id);
        this.setName(name);
        this.setType(type);
        this.setAl(al);
        this.setManufacturer(manufacturer);
        this.setIngredients(ingredients);
        this.setCrs(crs);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type.equals("Lager") || type.equals("Black") || type.equals("Light") || type.equals("Alive"))
            this.type = type;
        else
            try {
                throw new TypeException("Beer " + id + " -> " + type +" type is not registered!!!");
            } catch (TypeException e) {
                logger.error(e);
            }
    }

    public boolean isAl() {
        return al;
    }

    public void setAl(boolean al) {
        this.al = al;
    }

    public boolean getAl() {
        return al;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Chars getCrs() {
        return crs;
    }

    public void setCrs(Chars crs) {
        this.crs = crs;
    }

    @Override
    public String toString() {
        String sb = "Beer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", al=" + al +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=[";

        for (int i = 0; i < ingredients.size(); i++) {
            if(i == 0)
                sb += ingredients.get(i);
            else
                sb += ", " + ingredients.get(i);
        }
        sb += "], crs=" + crs + '}';
        return sb;
    }

}
