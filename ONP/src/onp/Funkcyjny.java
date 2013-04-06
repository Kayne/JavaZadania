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
public interface Funkcyjny extends Obliczalny {
    int arność();
    int brakująceArgumenty();
    void dodajArguemnt (double argument) throws WyjątekONP;
}
