/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public class Minimum extends Operator2Arg {

    public Minimum(Wyrazenie a1, Wyrazenie a2) {
        super(a1, a2);
    }

    @Override
    public int oblicz() {
        if (arg1.oblicz() > arg2.oblicz()) {
            return arg2.oblicz();
        } else {
            return arg1.oblicz();
        }
    }

    @Override
    public String toString() {
        return "(min(" + arg1 + ", " + arg2 + "))";
    }
}
