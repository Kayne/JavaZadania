/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatoronp.narzedzia;

/**
 *
 * @author kayne
 */
public class ONP_NiedozwolonaZmienna extends WyjatekONP {
    
    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_NiedozwolonaZmienna (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_NiedozwolonaZmienna: " + super.kumunikat;
    }
    
}
