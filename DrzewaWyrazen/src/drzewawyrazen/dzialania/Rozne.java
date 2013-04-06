/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public class Rozne extends Operator2Arg {

    public Rozne(Wyrazenie a1, Wyrazenie a2) {
        super(a1, a2);
    }

    @Override
    public int oblicz() {
        if (arg1.oblicz() != arg2.oblicz()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + arg1 + " != " + arg2 + ")";
    }
}
