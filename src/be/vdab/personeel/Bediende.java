package be.vdab.personeel;

import be.vdab.exceptions.DatumOutOfBoundsException;
import be.vdab.exceptions.NaamException;
import be.vdab.exceptions.PersoneelsNrException;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author simon.chaffart
 */
public class Bediende extends Werknemer {
    private static final long serialVersionUID = 1L;
    
    private BigDecimal maandwedde;
    
    /**
     * De datum van indiensttreding kan niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param maandwedde kan niet lager zijn dan 1129.47
     */
    public Bediende(int personeelsnr, WerknemersDatum datumInDienst, String naam, double maandwedde) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException
    {
        super(personeelsnr, datumInDienst, naam);
        setMaandwedde(maandwedde);
    }

    /**
     * De datum van indiensttreding kan niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param maandwedde kan niet lager zijn dan 1129.47
     * @param geslacht kan geset worden als "M" (voor een man) of "V" (voor een vrouw)
     */
    public Bediende(int personeelsnr, WerknemersDatum datumInDienst, String naam, double maandwedde, Geslacht geslacht) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException
    {
        super(personeelsnr, datumInDienst, naam, geslacht);
        setMaandwedde(maandwedde);
    }

    public double getMaandwedde()
    {
        return maandwedde.doubleValue();
    }

    public void setMaandwedde(double maandwedde)
    {
        if (maandwedde >= 1129.47) {
            this.maandwedde = BigDecimal.valueOf(maandwedde);
        }
        else {
            this.maandwedde = BigDecimal.valueOf(1129.47);
        }
    }

    @Override
    public BigDecimal getVerloning()
    {
        return maandwedde.setScale(2, RoundingMode.HALF_UP);
    }
}
