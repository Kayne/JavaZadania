/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen;

import drzewawyrazen.dzialania.*;

/**
 *
 * @author kayne
 */
public class DrzewaWyrazen {

    private static void drukuj(Wyrazenie wyrazenie) {
        System.out.println(wyrazenie + " = " + wyrazenie.oblicz());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wyrazenie w = new Dodaj(
                new Liczba(3),
                new Liczba(5));
        drukuj(w);
        w = new Dodaj(
                new Liczba(2),
                new Mnoz(
                new Zmienna("x"),
                new Liczba(7)));
        drukuj(w);
        w = new Dziel(
                new Odejmij(
                new Mnoz(
                new Liczba(3),
                new Liczba(11)),
                new Liczba(1)),
                new Dodaj(
                new Liczba(7),
                new Liczba(5)));
        drukuj(w);
        w = new Dziel(
                new Mnoz(
                new Dodaj(
                new Zmienna("x"),
                new Liczba(13)),
                new Zmienna("x")),
                new Liczba(2));
        drukuj(w);
        w = new Mniejsze(
                new Dodaj(
                new Mnoz(
                new Liczba(17),
                new Zmienna("x")),
                new Liczba(19)),
                new Liczba(0));
        drukuj(w);
    }
}
