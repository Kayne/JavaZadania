/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kayne
 */
public class Zbior {

    List<Para> lista = new ArrayList<>();

    public void wstaw(String kl, int wart) throws IllegalArgumentException {
        if (szukaj(kl) == 0) {
            lista.add(new Para(kl, wart));
        }
        else
        {
            throw new IllegalArgumentException("Jest już taki element w zbiorze!");
        }
    }

    public int szukaj(String kl) throws IllegalArgumentException {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).get(kl) != 0) {
                return lista.get(i).get(kl);
            }
        }
        return 0;
    }

    public int ile() {
        return lista.size();
    }

    public void czysc() {
        lista.clear();
    }
}
