/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.dzialania;
import static java.lang.Math.*;

/**
 *
 * @author kayne
 */
public class WartBezwzgl extends Operator1Arg {

    public WartBezwzgl(Wyrazenie a1) {
        super(a1);
    }

    @Override
    public int oblicz() {
        return abs(arg1.oblicz());
    }

    @Override
    public String toString() {
        return "|" + arg1 + "|";
    }
}
