/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp.funkcje;

import onp.Obliczalny;
import onp.wyjątki.*;

/**
 *
 * @author kayne
 */
public class Dziel extends Funkcja implements Obliczalny {
    
    double wartość = 0;

    public Dziel (double w, double w2) throws ONP_DzieleniePrzez0 {
        if (w2 == 0) {
            throw new ONP_DzieleniePrzez0();
        }
        wartość = w / w2;
    }
    
    @Override
    public double obliczWartość() throws WyjątekONP {
        return wartość;
    }
    
}
