package be.vdab.personeel.kader;

import be.vdab.exceptions.DatumOutOfBoundsException;
import be.vdab.exceptions.FunctieTitelException;
import be.vdab.exceptions.NaamException;
import be.vdab.exceptions.PersoneelsNrException;
import be.vdab.personeel.Bediende;
import be.vdab.util.Functietitel;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

/**
 *
 * @author simon.chaffart
 */
public class Kaderlid extends Bediende {
    private static final long serialVersionUID = 1L;

    private Functietitel functietitel;

    /**
     * De datum van indiensttreding kan niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param maandwedde kan niet lager zijn dan 1129.47
     * @param functietitel kan geset worden als "DIRECTEUR", "CEO", "MANAGER" (wordt geset op "MANAGER" als null wordt opgegeven als parameter )
     */
    public Kaderlid(int personeelsnr, WerknemersDatum datumInDienst, String naam, double maandwedde, Functietitel functietitel) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException, FunctieTitelException
    {
        super(personeelsnr, datumInDienst, naam, maandwedde);
        setFunctietitel(functietitel);
    }

    /**
     * De datum van indiensttreding kan niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param maandwedde kan niet lager zijn dan 1129.47
     * @param functietitel kan geset worden als "DIRECTEUR", "CEO", "MANAGER" (wordt geset op "MANAGER" als null als parameter wordt meegegeven)
     * @param geslacht kan geset worden als "M" (voor een man) of "V" (voor een vrouw)
     */
    public Kaderlid(int personeelsnr, WerknemersDatum datumInDienst, String naam, double maandwedde, Functietitel functietitel, Geslacht geslacht) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException, FunctieTitelException
    {
        super(personeelsnr, datumInDienst, naam, maandwedde, geslacht);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel()
    {
        return functietitel;
    }

    public void setFunctietitel(Functietitel functietitel) throws FunctieTitelException
    {
        if (functietitel != null) {
            this.functietitel = functietitel;
        }
        else {
            throw new FunctieTitelException("Functietitel mag niet null zijn");
        }
    }
}
