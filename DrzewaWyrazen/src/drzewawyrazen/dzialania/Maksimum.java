/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public class Maksimum extends Operator2Arg {

    public Maksimum(Wyrazenie a1, Wyrazenie a2) {
        super(a1, a2);
    }

    @Override
    public int oblicz() {
        if (arg1.oblicz() > arg2.oblicz()) {
            return arg1.oblicz();
        } else {
            return arg2.oblicz();
        }
    }

    @Override
    public String toString() {
        return "(max(" + arg1 + ", " + arg2 + "))";
    }
}
