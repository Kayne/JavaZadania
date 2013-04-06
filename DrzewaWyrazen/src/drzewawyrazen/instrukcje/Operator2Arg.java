/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.instrukcje;

/**
 *
 * @author kayne
 */
public abstract class Operator2Arg extends Operator1Arg {

    protected final Instrukcja arg2;

    public Operator2Arg(Instrukcja a1, Instrukcja a2) throws IllegalArgumentException {
        super(a1);
        if (a2 == null) {
            throw new IllegalArgumentException();
        }
        arg2 = a2;
    }
}