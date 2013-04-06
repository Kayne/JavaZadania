/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.instrukcje;

/**
 *
 * @author kayne
 */
public class Program {

    private static void drukuj(Instrukcja instrukcja) {
        System.out.println(instrukcja + "\n" + instrukcja.wykonaj());
    }

    public static void main(String[] args) {
        Instrukcja i = new If(
                new Liczba(5),
                new Liczba(7),
                "<");
        drukuj(i);
    }
}