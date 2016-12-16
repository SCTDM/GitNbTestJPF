package be.vdab.main;

import be.vdab.exceptions.DatumOutOfBoundsException;
import be.vdab.util.Datum;

/**
 *
 * @author simon.chaffart
 */
public class DatumTesten {
    public static void main(String[] args)
    {
        System.out.println("JAARTALLEN:");
        // te klein jaartal
        try {
            System.out.print("1/1/1583: ");
            
            Datum datum = new Datum(1, 1, 1583);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // correct jaartal
        try {
            System.out.print("1/1/1584: ");
            
            Datum datum = new Datum(1, 1, 1584);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // te groot jaartal
        try {
            System.out.print("1/1/4100: ");
            
            Datum datum = new Datum(1, 1, 4100);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een correct jaartal
        try {
            System.out.print("1/1/4099: ");
            
            Datum datum = new Datum(1, 1, 4099);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        System.out.println("\nMAANDEN:");
        // een te grote maand
        try {
            System.out.print("14/13/2016: ");
            
            Datum datum = new Datum(14, 13, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
         // een correcte maand
        try {
            System.out.print("14/12/2016: ");
            
            Datum datum = new Datum(14, 12, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een te kleine maand
        try {
            System.out.print("14/0/2016: ");
            
            Datum datum = new Datum(14, 0, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een correcte maand
        try {
            System.out.print("14/1/2016: ");
            
            Datum datum = new Datum(14, 1, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        System.out.println("\nDAGEN:");
        // een te kleine dag
        try {
            System.out.print("0/12/2016: ");
            
            Datum datum = new Datum(0, 12, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een correcte dag
        try {
            System.out.print("1/12/2016: ");
            
            Datum datum = new Datum(1, 12, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een te grote dag
        try {
            System.out.print("32/12/2016: ");
            
            Datum datum = new Datum(32, 12, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een te grote dag
        try {
            System.out.print("31/12/2016: ");
            
            Datum datum = new Datum(31, 12, 2016);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        System.out.println("\nSCHRIKKELJAREN:");
        
        // een schrikkeljaar
        try {
            System.out.print("29/2/1996: ");
            
            Datum datum = new Datum(29, 2, 1996);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // geen schrikkeljaar
        try {
            System.out.print("29/2/1997: ");
            
            
            Datum datum = new Datum(29, 2, 1997);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een schrikkeljaar
        try {
            System.out.print("29/2/2000: ");
            
            Datum datum = new Datum(29, 2, 2000);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // geen schrikkeljaar
        try {
            System.out.print("29/2/2001: ");
            
            Datum datum = new Datum(29, 2, 2001);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // een schrikkeljaar
        try {
            System.out.print("29/2/2004: ");
            
            Datum datum = new Datum(29, 2, 2004);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
        
        // geen schrikkeljaar
        try {
            System.out.print("29/2/1900: ");
            
            Datum datum = new Datum(29, 2, 1900);
            
            System.out.println("OK");
        }
        catch ( DatumOutOfBoundsException ex ) {
            System.out.println(ex.toString());
        }
    }
}
