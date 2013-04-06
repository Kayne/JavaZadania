/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robaki;

/**
 *
 * @author kayne
 */
public class Para {
    
    private int x;
    private int y;
    
    public Para(int kolumna, int wiersz) {
        x = kolumna;
        y = wiersz;
    }
    
    public int getKolumna() {
        return x;
    }
    
    public int getWiersz() {
        return y;
    }
    
    public boolean equals(Para o) {
        return x == o.x && y == o.y;
    }
}
