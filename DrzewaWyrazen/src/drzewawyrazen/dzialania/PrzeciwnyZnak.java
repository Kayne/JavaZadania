/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;

/**
 *
 * @author kayne
 */
public class PrzeciwnyZnak extends Operator1Arg {

    public PrzeciwnyZnak(Wyrazenie a1) {
        super(a1);
    }

    @Override
    public int oblicz() {
        return arg1.oblicz() * -1;
    }

    @Override
    public String toString() {
        return "(" + arg1 + " * -1)";
    }
}
