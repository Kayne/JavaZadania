/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public abstract class Operator1Arg extends Wyrazenie {
    protected final Wyrazenie arg1;

    public Operator1Arg (Wyrazenie a1) throws IllegalArgumentException {
        if (a1==null) {
            throw new IllegalArgumentException();
        }
        arg1 = a1;
    }
}