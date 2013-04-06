/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robaki;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa obsługująca logikę aplikacji, czyli wirtualna plansza, ruchy robaków itd.
 * @author kayne
 */
public class Logika {
    int[][] plansza;
    int kolumn = 10;
    int wierszy = 10;
    
    List<Thread> watki = new ArrayList<>();
    List<Robak> robaczki = new ArrayList<>();
    
    public void addThread(Thread th){
        watki.add(th);
        watki.get(watki.size()-1).start();
    }
    
    public void addRobak(Robak robaczek) {
        robaczki.add(robaczek);
    }
    
    public Robak getRobaczek(int numer) {
        return robaczki.get(numer-1);
    }
    
    public Logika() {
        plansza = new int[kolumn][wierszy];
        wyzerujPlanszę();
    }
    
    public Logika(int kolumny, int wiersze) {
        kolumn = kolumny;
        wierszy = wiersze;
        plansza = new int[kolumn][wierszy];
        wyzerujPlanszę();
    }
    
    private void wyzerujPlanszę() {
        for (int i = 0; i < kolumn; i++) {
            for (int j = 0; j < wierszy; j++) {
                plansza[i][j] = 0;
            }
        }
    }
    
    public  void dodajNaPole(int kolumna, int wiersz, int numer) {
        plansza[kolumna][wiersz] = numer;
    }
    
    public  int isZajęte(int kolumna, int wiersz) {
        return plansza[kolumna][wiersz];
    }
    
    public  void usuńZPola(int kolumna, int wiersz) {
        plansza[kolumna][wiersz] = 0;
    }
    
    public  void usuńPole(int kolumna, int wiersz) {
        plansza[kolumna][wiersz] = 0;
    }
    
    public int getKolumn() {
        return kolumn;
    }
    
    public int getWierszy() {
        return wierszy;
    }
}
