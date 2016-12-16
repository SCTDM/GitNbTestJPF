package be.vdab.personeel;

import be.vdab.exceptions.DatumOutOfBoundsException;
import be.vdab.exceptions.NaamException;
import be.vdab.exceptions.PersoneelsNrException;
import be.vdab.util.Geslacht;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.WerknemersDatum;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author simon.chaffart
 */
public abstract class Werknemer implements Comparable<Werknemer>, Serializable {
    private static final long serialVersionUID = 1L;

    private final int personeelsnr;
    private WerknemersDatum datumInDienst;
    private String naam;
    private Geslacht geslacht;

    /**
     * De datum van indiensttreding mag niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     */
    public Werknemer(int personeelsnr, int dag, int maand, int jaar, String naam) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException
    {
        if (personeelsnr > 0) {
            this.personeelsnr = personeelsnr;
        }
        else {
            throw new PersoneelsNrException("Personeelsnummer is kleiner dan de kleinst toegelaten waarde: 1");
        }
        setDatumInDienst(dag, maand, jaar);
        setNaam(naam);
    }

    /**
     * De datum van indiensttreding mag niet vroeger zijn dan 12/2/1977
     *
     * @param personeelsnr moet groter zijn dan 0
     * @param naam mag niet leeg zijn
     * @param geslacht kan geset worden als "M" (voor een man) of "V" (voor een vrouw)
     */
    public Werknemer(int personeelsnr, int dag, int maand, int jaar, String naam, Geslacht geslacht) throws NaamException, PersoneelsNrException, DatumOutOfBoundsException
    {
        this(personeelsnr, dag, maand, jaar, naam);
        setGeslacht(geslacht);
    }

    public abstract BigDecimal getVerloning();

    public WerknemersDatum getDatumInDienst()
    {
        return datumInDienst;
    }

    public void setDatumInDienst(int dag, int maand, int jaar) throws DatumOutOfBoundsException
    {
        this.datumInDienst = new WerknemersDatum(dag, maand, jaar);
    }

    public String getNaam()
    {
        return naam;
    }

    public void setNaam(String naam) throws NaamException
    {
        if (naam != null && !naam.trim().isEmpty()) {
            this.naam = naam;
        }
        else {
            if (naam == null) {
                throw new NaamException("De waarde voor de naam mag niet null zijn");
            }
            if (naam.isEmpty()) {
                throw new NaamException("De waarde voor de naam mag niet leeg zijn");
            }
            if (naam.trim().isEmpty()) {
                throw new NaamException("De waarde voor de naam mag niet enkel spaties bevatten");
            }
        }
    }

    public Geslacht getGeslacht()
    {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht)
    {
        this.geslacht = geslacht;
    }

    @Override
    public int compareTo(Werknemer other)
    {
        return this.personeelsnr - other.personeelsnr;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(personeelsnr).append("\t").append(datumInDienst).append("\t").append(naam);
        if (getClass() == Kaderlid.class) {
            Kaderlid kaderlid = (Kaderlid) this;
            sb.append("\t").append(kaderlid.getFunctietitel());
        }
        if (getClass() == Arbeider.class) {
            sb.append("\t").append("ARBEIDER");
        }
        if (getClass() == Bediende.class) {
            sb.append("\t").append("BEDIENDE");
        }
        if (geslacht != null) {
            sb.append("\t").append(geslacht);
        }
        sb.append("\t").append(getVerloning());
        return sb.toString();
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + this.personeelsnr;
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
        final Werknemer other = (Werknemer) obj;
        if (this.personeelsnr != other.personeelsnr) {
            return false;
        }
        return true;
    }
}
