/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen;

/**
 *
 * @author kayne
 */
public class Para {

    public final String klucz;
    private int wartosc;

    public Para(String k, int w) {
        klucz = k;
        set(k, w);
    }

    public int get(String klucz2) {
        if (klucz2.compareTo(klucz) == 1) {
            return wartosc;
        } else {
            return 0;
        }
    }

    public final void set(String klucz2, int wart) {
        if (klucz2.compareTo(klucz) == 1) {
            wartosc = wart;
        }
    }
}
