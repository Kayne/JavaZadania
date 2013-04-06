/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.instrukcje;

/**
 *
 * @author kayne
 */
public abstract class Operator1Arg extends Instrukcja {

    protected final Instrukcja arg1;

    public Operator1Arg(Instrukcja a1) throws IllegalArgumentException {
        if (a1 == null) {
            throw new IllegalArgumentException();
        }
        arg1 = a1;
    }
}