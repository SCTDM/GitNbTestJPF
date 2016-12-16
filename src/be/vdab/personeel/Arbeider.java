package be.vdab.personeel;

import be.vdab.exceptions.DatumOutOfBoundsException;
import be.vdab.exceptions.NaamException;
import be.vdab.exceptions.PersoneelsNrException;
import be.vdab.util.Geslacht;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author simon.chaffart
 */
public class Arbeider extends Werknemer {
    private static final long serialVersionUID = 1L;

    private BigDecimal uurloon;

    /**
     * De datum van indiensttreding kan niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param uurloon kan niet lager zijn dan 9.76
     */
    public Arbeider(int personeelsnr, int dag, int maand, int jaar, String naam, double uurloon) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException
    {
        super(personeelsnr, dag, maand, jaar, naam);
        setUurloon(uurloon);
    }

    /**
     * De datum van indiensttreding kan niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param uurloon kan niet lager zijn dan 9.76
     * @param geslacht kan geset worden als "M" (voor een man) of "V" (voor een vrouw)
     */
    public Arbeider(int personeelsnr, int dag, int maand, int jaar, String naam, double uurloon, Geslacht geslacht) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException
    {
        super(personeelsnr, dag, maand, jaar, naam, geslacht);
        setUurloon(uurloon);
    }

    public double getUurloon()
    {
        return uurloon.doubleValue();
    }

    public void setUurloon(double uurloon)
    {
        if (uurloon >= 9.76) {
            this.uurloon = BigDecimal.valueOf(uurloon);
        }
        else {
            this.uurloon = BigDecimal.valueOf(9.76);
        }
    }

    @Override
    public BigDecimal getVerloning()
    {
        return uurloon.multiply(BigDecimal.valueOf(7.6)).multiply(BigDecimal.valueOf(65)).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
    }

}
