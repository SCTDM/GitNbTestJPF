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
    
    /** Er kan geen datum ingegeven worden vóór 12/2/1977
     *
     * @throws DatumOutOfBoundsException Thrown if attempting to initialize a WerknemersDatum with a date earlier than 12/2/1977 
     */
    public WerknemersDatum(int dag, int maand, int jaar) throws DatumOutOfBoundsException
    {
        super(dag, maand, jaar);
    }   

    @Override
    protected void datumNotOutOfBounds(int dag, int maand, int jaar) throws DatumOutOfBoundsException
    {
        super.datumNotOutOfBounds(dag, maand, jaar);
        Datum tmp = new Datum(dag, maand, jaar);
        if (tmp.compareTo(OPRICHTINGSDATUM) <= 0) {
            throw new DatumOutOfBoundsException("Indiensttredingsdatum " + tmp + " is niet geldig, kan niet voor 12/02/1977 zijn");
        }
    }
}
