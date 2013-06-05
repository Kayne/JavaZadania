/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dziesietnenabinarne;

import java.util.Scanner;

/**
 *
 * @author kayne
 */
public class DziesietneNaBinarne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Wpisz liczbę dziesiętną: ");
        Scanner x = new Scanner(System.in);
        String wynik = dziesietne(x.nextInt(), "");
        System.out.println(wynik);
    }

    public static String dziesietne(int dziesietna, String wynik) {
        // DEBUG
        // System.out.println(dziesietna + " | " + wynik);

        if (dziesietna == 0) {
            if (wynik.isEmpty()) {
                wynik += "0";
            }
            return new StringBuilder(wynik).reverse().toString();
        }

        if (dziesietna % 2 == 0) {
            wynik += "0";
        } else {
            wynik += "1";
        }

        return dziesietne(dziesietna / 2, wynik);
    }
}
