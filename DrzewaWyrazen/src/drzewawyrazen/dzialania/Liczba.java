/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public class Liczba extends Wyrazenie {

    protected final int liczba;

    public Liczba(int l) {
        liczba = l;
    }

    @Override
    public int oblicz() {
        return liczba;
    }

    @Override
    public String toString() {
        return String.valueOf(liczba);
    }
}
