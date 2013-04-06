/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public class Dodaj extends Operator2Arg {

    public Dodaj(Wyrazenie a1, Wyrazenie a2) {
        super(a1, a2);
    }

    @Override
    public int oblicz() {
        return arg1.oblicz() + arg2.oblicz();
    }

    @Override
    public String toString() {
        return "(" + arg1 + " + " + arg2 + ")";
    }
}
