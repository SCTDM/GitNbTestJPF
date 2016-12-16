package be.vdab.util;

import be.vdab.exceptions.DatumOutOfBoundsException;

/**
 *
 * @author simon.chaffart
 */
public class WerknemersDatum extends Datum {
    private static final long serialVersionUID = 1L;
    
    public static final Datum OPRICHTINGSDATUM;
    static {
        Datum tmp = null;
     try {
       tmp = new Datum(12, 2, 1977);
     } 
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
     OPRICHTINGSDATUM = tmp;
    }
    
    /**
     *
     * @throws DatumOutOfBoundsException  
     */
    public WerknemersDatum(int dag, int maand, int jaar) throws DatumOutOfBoundsException
    {
        super(dag, maand, jaar);
    }

    @Override
    public String toString()
    {
        return "[" + getDag() + "/" + getMaand() + "/" + getJaar() + "]";
    }
}
