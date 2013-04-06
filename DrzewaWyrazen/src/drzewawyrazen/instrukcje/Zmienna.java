/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.instrukcje;

import drzewawyrazen.Zbior;

/**
 *
 * @author kayne
 */
public class Zmienna extends Instrukcja {

    public static Zbior zmienne = new Zbior();

    static {
        zmienne.wstaw("x", 1);
    }
    protected final String zmienna;
    protected int zmienna_wartosc;

    public Zmienna(String z) {
        zmienna = z;
    }

    @Override
    public int wykonaj() {
        return zmienne.szukaj(zmienna);
    }

    @Override
    public String toString() {
        return String.valueOf(zmienna);
    }
}
