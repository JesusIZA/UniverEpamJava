package moduleWork3.entitys;

import moduleWork3.exceptions.KlOborException;
import moduleWork3.exceptions.OpacityException;
import moduleWork3.exceptions.VException;
import org.apache.log4j.Logger;

/**
 * Chars of Beer class
 *
 * @author Jesus Raichuk
 */
public class Chars {
    /**
     * KlObor of the beer
     */
    private double klObor = 0.0;
    /**
     * Opacity of the beer
     */
    private int opacity = 0;
    /**
     * Is filtered or not the beer
     */
    private boolean filtered = false;
    /**
     * Energy value of the beer
     */
    private double kkal = 0.0;
    /**
     * Package of the beer
     */
    private String tara = "noTareEntered";
    /**
     * Volume of the beer
     */
    private double V = 0.0;
    /**
     * Logger
     */
    private static Logger logger = Logger.getLogger(Chars.class);

    public Chars() {
    }

    public Chars(double klObor, int opacity, boolean filtered, double kkal, String tara, double v) {
        this.setKlObor(klObor);
        this.setOpacity(opacity);
        this.setFiltered(filtered);
        this.setKkal(kkal);
        this.setTara(tara);
        this.setV(v);
    }

    public double getKlObor() {
        return klObor;
    }

    public void setKlObor(double klObor) {
        if(klObor >= 0 && klObor < 99)
            this.klObor = klObor;
        else
            try {
                throw new KlOborException("Beer klObor Error -> " + klObor +" out of possible bounds!!!");
            } catch (KlOborException e) {
                logger.error(e);
            }
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        if(opacity >= 1 && opacity <= 99)
            this.opacity = opacity;
        else
            try {
                throw new OpacityException("Beer opasity Error -> " + opacity +" out of possible bounds!!!");
            } catch (OpacityException e) {
                logger.error(e);
            }
    }

    public boolean isFiltered() {
        return filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    public double getKkal() {
        return kkal;
    }

    public void setKkal(double kkal) {
        this.kkal = kkal;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public double getV() {
        return V;
    }

    public void setV(double v) {
        if(v > 0.1 && v < 1000.0)
            V = v;
        else
            try {
                throw new VException("Beer V Error -> " + v +" out of possible bounds!!!");
            } catch (VException e) {
                logger.error(e);
            }
    }

    @Override
    public String toString() {
        return "Chars{" +
                "klObor=" + klObor +
                ", opacity=" + opacity +
                ", filtered=" + filtered +
                ", kkal=" + kkal +
                ", tara='" + tara + '\'' +
                ", V=" + V +
                '}';
    }
}
