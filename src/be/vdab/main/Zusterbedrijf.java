package be.vdab.main;

import be.vdab.personeel.Werknemer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author simon.chaffart
 */
public class Zusterbedrijf {
    public static void main(String[] args)
    {
        SortedSet<Werknemer> werknemers = new TreeSet<>();

        try (FileInputStream fis = new FileInputStream("personeel.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            werknemers = (TreeSet<Werknemer>) ois.readObject();
        }
        catch ( Exception ex ) {
            System.out.println(ex.toString());
        }
        
        werknemers.stream().forEach(System.out::println);
    }
}
