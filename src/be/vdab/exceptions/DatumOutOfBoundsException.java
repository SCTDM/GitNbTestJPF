package be.vdab.exceptions;

/**
 *
 * @author simon.chaffart
 */
public class DatumOutOfBoundsException extends Exception {
    
    public DatumOutOfBoundsException()
    {
        super("De datum heeft geen geldige waarde tussen 1/1/1584 en 31/12/4099");
    }
    
}
