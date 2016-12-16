package be.vdab.exceptions;

/**
 *
 * @author simon.chaffart
 */
public class PersoneelsNrException extends Exception {
    public PersoneelsNrException()
    {
        super("PersoneelsNr is kleiner dan 1");
    }
}
