package be.vdab.main;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Werknemer;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.Functietitel;
import be.vdab.util.Geslacht;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon.chaffart
 */
public class Bedrijf {
    public static void main(String[] args)
    {
        Set<Werknemer> werknemers = new TreeSet<>();

        // Arbeider zonder geslacht
        try {
            werknemers.add(new Arbeider(5, 1, 12, 1980, "Jef Peeters", 10));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Arbeider met geslacht
        try {
            werknemers.add(new Arbeider(1, 1, 8, 1990, "Bart Vercauteren", 10.5, Geslacht.M));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Bediende zonder geslacht
        try {
            werknemers.add(new Bediende(4, 1, 4, 1990, "Marie Christine", 1503.40));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Bediende met geslacht
        try {
            werknemers.add(new Bediende(2, 1, 6, 1995, "Joële Marie",
                    1550.23, Geslacht.V));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Kaderlid zonder geslacht
        try {
            werknemers.add(new Kaderlid(3, 1, 2, 2000, "Erik Goossens", 2102.30, null));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }

        // Kaderlid met geslacht
        try {
            werknemers.add(new Kaderlid(6, 1, 3, 2005, "Stijn Peeters", 2303.20, Functietitel.CEO , Geslacht.M));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }
        
        // Arbeider met slechte indienstredingsdatum
        
        try {
            werknemers.add(new Arbeider(7, 11, 2, 1977, "Bart Vercauteren", 10.5, Geslacht.M));
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }
        
        ///////////////// Print out van set ///////////////////
        werknemers.stream().forEach(System.out::println);

        //////////////// Serialisatie van Set /////////////////
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personeel.dat"));) {
//            oos.writeObject(werknemers);
//        }
//        catch ( IOException ex ) {
//            System.out.println(ex.toString());
//        }
    }
}
