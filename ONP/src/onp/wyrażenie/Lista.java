/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp.wyrażenie;

import java.util.ArrayList;
import java.util.List;
import onp.Zmienna;
import onp.wyjątki.WyjątekONP;

/**
 *
 * @author kayne
 */
public class Lista {
    
    List<Zmienna> zmienne = new ArrayList<Zmienna>();
    
    public void dodaj(Zmienna z) {
        zmienne.add(z);
    }
    
    public double getWartośćZmiennej(char z) throws WyjątekONP {
        Zmienna temp = null;
        double wynik = 0;
        for (int i = 0; i < zmienne.size(); i++) {
            temp = zmienne.get(i);
            if (temp.getNazwa().equals(Character.toString(z))) {
                wynik = temp.obliczWartość();
                break;
            }
        }
        return wynik;
    }
}