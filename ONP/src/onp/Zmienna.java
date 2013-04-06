/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp;

import onp.wyjątki.WyjątekONP;

/**
 *
 * @author kayne
 */
public class Zmienna extends Operand implements Obliczalny {
    String nazwa;
    double wartość;
    
    public Zmienna (String n, double w) {
        nazwa = n;
        wartość = w;
    }
    
    public void setWartość(double w) {
        wartość = w;
    }
    
    public double getWartość() {
        return wartość;
    }
    
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public double obliczWartość() throws WyjątekONP {
        return wartość;
    }
}
