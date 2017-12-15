package homeWork.hw8.etitys;

/**
 * Class realize Flight
 *
 * @author Jesus Raichuk
 */
public class Flight {
    /**
     * Flight ID
     */
    private int id;
    /**
     * Airline ID
     */
    private int aid;
    /**
     * Flight begin place
     */
    private String pForm;
    /**
     * Flight end place
     */
    private String pTo;
    /**
     * Flight time in air
     */
    private double timeInAir;

    public Flight() {
    }

    public Flight(int id, int aid, String form, String to, double timeInAir) {
        this.id = id;
        this.aid = aid;
        this.pForm = form;
        this.pTo = to;
        this.timeInAir = timeInAir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getForm() {
        return pForm;
    }

    public void setForm(String form) {
        this.pForm = form;
    }

    public String getTo() {
        return pTo;
    }

    public void setTo(String to) {
        this.pTo = to;
    }

    public double getTimeInAir() {
        return timeInAir;
    }

    public void setTimeInAir(double timeInAir) {
        this.timeInAir = timeInAir;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", aid=" + aid +
                ", pForm='" + pForm + '\'' +
                ", pTo='" + pTo + '\'' +
                ", timeInAir=" + timeInAir +
                '}';
    }
}
