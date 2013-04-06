/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.instrukcje;

/**
 *
 * @author kayne
 */
public class Liczba extends Instrukcja {

    protected final int liczba;

    public Liczba(int l) {
        liczba = l;
    }

    @Override
    public int wykonaj() {
        return liczba;
    }

    @Override
    public String toString() {
        return String.valueOf(liczba);
    }
}
