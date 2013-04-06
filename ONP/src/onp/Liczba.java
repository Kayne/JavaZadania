/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp;

/**
 *
 * @author kayne
 */
public class Liczba extends Operand {
    double liczba;
    
    public Liczba (double l) {
        liczba = l;
    }
    
    public double getLiczba() {
        return liczba;
    }
}
