package be.vdab.util;

import be.vdab.exceptions.DatumOutOfBoundsException;
import java.io.Serializable;

/**
 *
 * @author simon.chaffart
 */
public class Datum implements IDatum, Comparable, Serializable {
    private static final long serialVersionUID = 1L;
    
    private final int dag;
    private final int maand;
    private final int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumOutOfBoundsException
    {
        if (datumNotOutOfBounds(dag, maand, jaar)) {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        }
        else {
            throw new DatumOutOfBoundsException();
        }
    }

    private boolean datumNotOutOfBounds(int dag, int maand, int jaar)
    {
        if (jaar > 4099 || jaar < 1584) {
            return false;
        }
        if (maand > 12 || maand < 1) {
            return false;
        }
        if (dag < 1 || dag > 31) {
            return false;
        }
        switch (maand) {
            case 2:
                if (isSchrikkeljaar(jaar)) {
                    if (dag > 29) {
                        return false;
                    }
                }
                else {
                    if (dag > 28) {
                        return false;
                    }
                }
                break;
            case 4:
                if (dag > 30) {
                    return false;
                }
                break;
            case 6:
                if (dag > 30) {
                    return false;
                }
                break;
            case 9:
                if (dag > 30) {
                    return false;
                }
                break;
            case 11:
                if (dag > 30) {
                    return false;
                }
                break;
        }
        return true;
    }

    private boolean isSchrikkeljaar(int jaar)
    {
        boolean schrikkeljaar = false;

        if (jaar % 4 == 0) {
            schrikkeljaar = true;
        }
        if (jaar % 100 == 0) {
            schrikkeljaar = false;
        }
        if (jaar % 400 == 0) {
            schrikkeljaar = true;
        }

        return schrikkeljaar;
    }

    @Override
    public int getDag()
    {
        return dag;
    }

    @Override
    public int getMaand()
    {
        return maand;
    }

    @Override
    public int getJaar()
    {
        return jaar;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + this.jaar;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Datum other = (Datum) obj;
        if (this.dag != other.dag) {
            return false;
        }
        if (this.maand != other.maand) {
            return false;
        }
        if (this.jaar != other.jaar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Datum: " + dag + "/" + maand + "/" + jaar;
    }

    @Override
    public int compareTo(Object o)
    {
//        try {
            Datum other = (Datum) o;
            if (this.getJaar() == other.getJaar()) {
                if (this.getMaand() == other.getMaand()) {
                    return this.getDag() - other.getDag();
                }
                else {
                    return this.getMaand() - other.getMaand();
                }
            }
            else {
                return this.getJaar() - other.getJaar();
            }
//        }
//        catch ( ClassCastException e ) {
//            System.out.println("Gefaald om naar Datum te casten");
//        }
    }
}
