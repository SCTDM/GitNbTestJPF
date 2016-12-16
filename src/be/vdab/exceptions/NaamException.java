package be.vdab.exceptions;

/**
 *
 * @author simon.chaffart
 */
public class NaamException extends Exception {
    public NaamException()
    {
        super("De naam is niet ingevuld");
    }
}
