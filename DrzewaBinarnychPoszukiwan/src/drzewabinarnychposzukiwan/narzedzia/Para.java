/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewabinarnychposzukiwan.narzedzia;

/**
 * Para przechowuje klucz i przyporzadkowaną do niego wartość.
 * @author kayne
 */
public class Para implements Comparable<Para> {
    /**
     * Przechowuje nazwę klucza pary.
     */
    public final String klucz;
    /**
     * Przechowuję wartość pary.
     */
    public final Double wartosc;
    
    /**
     * Konstruktor Pary, tworzy nową parę z kluczem i wartością.
     * @param k nazwa klucza
     * @param w wartość klucza
     */
    public Para(String k, Double w) {
        klucz = k;
        wartosc = w;
    }

    /**
     * Porównuje tą parę z inną.
     * @param p para do porównania
     * @return 1 dla prawdy i 0 dla fałszu
     */
    @Override
    public int compareTo(Para p) {
        if (this.klucz == null ? p.klucz == null : this.klucz.equals(p.klucz)) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
