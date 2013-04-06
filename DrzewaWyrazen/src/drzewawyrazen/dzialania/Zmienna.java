/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

import drzewawyrazen.*;

/**
 *
 * @author kayne
 */
public class Zmienna extends Wyrazenie {

    public static Zbior zmienne = new Zbior();

    static {
        zmienne.wstaw("x", -3);
    }
    protected final String zmienna;
    protected int zmienna_wartosc;

    public Zmienna(String z) {
        zmienna = z;
    }

    @Override
    public int oblicz() {
        return zmienne.szukaj(zmienna);
    }

    @Override
    public String toString() {
        return String.valueOf(zmienna);
    }
}
