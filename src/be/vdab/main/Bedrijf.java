package be.vdab.main;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Werknemer;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.Functietitel;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author simon.chaffart
 */
public class Bedrijf {
    public static void main(String[] args)
    {
        SortedSet<Werknemer> werknemers = new TreeSet<>();

        // Arbeider zonder geslacht
        try {
            werknemers.add(new Arbeider(5, new WerknemersDatum(1, 12, 1980), "Jef Peeters", BigDecimal.valueOf(10)));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Arbeider met geslacht
        try {
            werknemers.add(new Arbeider(1, new WerknemersDatum(1, 8, 1990), "Bart Vercauteren", BigDecimal.valueOf(10.5), Geslacht.M));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Bediende zonder geslacht
        try {
            werknemers.add(new Bediende(4, new WerknemersDatum(1, 4, 1990), "Marie Christine", 1503.40));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Bediende met geslacht
        try {
            werknemers.add(new Bediende(2, new WerknemersDatum(1, 6, 1995), "Joële Marie",
                    1550.23, Geslacht.V));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Kaderlid zonder geslacht
        try {
            werknemers.add(new Kaderlid(3, new WerknemersDatum(1, 2, 2000), "Erik Goossens", 2102.30, null));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Kaderlid met geslacht
        try {
            werknemers.add(new Kaderlid(6, new WerknemersDatum(1, 3, 2005), "Stijn Peeters", 2303.20, Functietitel.CEO , Geslacht.valueOf("M")));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }
        
        // Arbeider met slechte indienstredingsdatum
        
        try {
            werknemers.add(new Arbeider(7, new WerknemersDatum(11, 2, 1977), "Bart Vercauteren", BigDecimal.valueOf(10.5), Geslacht.M));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }
        
        ///////////////// Print out van SortedSet ///////////////////
        werknemers.forEach(System.out::println);

        //////////////// Serialisatie van Set /////////////////
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personeel.dat"));) {
//            oos.writeObject(werknemers);
//        }
//        catch ( IOException ex ) {
//            System.out.println(ex.toString());
//        }
    }
}
