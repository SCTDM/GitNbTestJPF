package be.vdab.exceptions;

/**
 *
 * @author simon.chaffart
 */
public class DatumIndiensttredingException extends Exception {
    public DatumIndiensttredingException()
    {
        super("Indiensttredingsdatum is niet geldig (kan niet voor 12/02/1977 zijn)");
    }
}
