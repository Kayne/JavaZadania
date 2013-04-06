/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robaki;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa reprezentująca jednego robaka.
 *
 * @author kayne
 */
public class Robak implements Runnable {

    private Para glowa;
    static private int iloscRobakow = 1;
    private int numer = 1;
    private Color kolor;
    /**
     * 1 - góra, 2 - w lewo, 3 - w prawo, 4 - w dół.
     */
    private Kierunek obecny_kierunek = Kierunek.W_GORE;
    private final Logika logika;
    Random randomGenerator = new Random();
    List<Para> lista = new ArrayList<>();

    public Robak(Logika log) {
        setNumerRobaka(iloscRobakow);
        iloscRobakow++;
        losujKolor();
        logika = log;
        int kolumna, wiersz;
        while (true) {
            kolumna = randomGenerator.nextInt(log.getKolumn());
            wiersz = randomGenerator.nextInt(log.getWierszy());
            if (logika.isZajęte(kolumna, wiersz) == 0) {
                break;
            }
        }
        synchronized (logika) {
            ustawGłowę(kolumna, wiersz);
        }
    }

    public Robak(Logika log, int kolumna, int wiersz) {
        setNumerRobaka(iloscRobakow);
        iloscRobakow++;
        losujKolor();
        logika = log;
        synchronized (logika) {
            ustawGłowę(kolumna, wiersz);
        }
    }

    private void setNumerRobaka(int num) {
        numer = num;
    }

    private void ustawGłowę(int kolumna, int wiersz) {
        glowa = new Para(kolumna, wiersz);
        logika.dodajNaPole(glowa.getKolumna(), glowa.getWiersz(), numer);
    }

    private void losujKolor() {
        kolor = new Color(randomGenerator.nextFloat(), randomGenerator.nextFloat(), randomGenerator.nextFloat());
    }

    public Color getKolor() {
        return kolor;
    }

    public int getGłowaKolumna() {
        return glowa.getKolumna();
    }

    public int getGłowaWiersz() {
        return glowa.getWiersz();
    }

    private void zmieńObecnyKierunekWLewo() {
        switch (obecny_kierunek) {
            case W_DOL:
                obecny_kierunek = Kierunek.W_PRAW;
                break;
            case W_GORE:
                obecny_kierunek = Kierunek.W_LEWO;
                break;
            case W_LEWO:
                obecny_kierunek = Kierunek.W_DOL;
                break;
            case W_PRAW:
                obecny_kierunek = Kierunek.W_GORE;
                break;
        }
    }

    private void zmieńObecnyKierunekWPrawo() {
        switch (obecny_kierunek) {
            case W_DOL:
                obecny_kierunek = Kierunek.W_LEWO;
                break;
            case W_GORE:
                obecny_kierunek = Kierunek.W_PRAW;
                break;
            case W_LEWO:
                obecny_kierunek = Kierunek.W_GORE;
                break;
            case W_PRAW:
                obecny_kierunek = Kierunek.W_DOL;
                break;
        }
    }

    private void ustalKierunekRuchu() {
        int losowanie = 0;
        losowanie = (int) (randomGenerator.nextInt(9) + 1);
        if (losowanie > 6) {
            if (losowanie == 8) {
                zmieńObecnyKierunekWLewo();
            }
            if (losowanie == 7) {
                zmieńObecnyKierunekWPrawo();
            }
        }
    }

    private void ruch() {
        synchronized (logika) {
            ustalKierunekRuchu();

            Para tempGlowa = null;
            boolean Mama_just_killed_a_man = false;

            switch (obecny_kierunek) {
                case W_DOL:
                    tempGlowa = new Para(glowa.getKolumna(),
                            (glowa.getWiersz() + 1) >= logika.getWierszy() ? 0 : (glowa.getWiersz() + 1));
                    break;
                case W_GORE:
                    tempGlowa = new Para(glowa.getKolumna(),
                            (glowa.getWiersz() - 1) < 0 ? logika.getWierszy() - 1 : (glowa.getWiersz() - 1));
                    break;
                case W_LEWO:
                    tempGlowa = new Para((glowa.getKolumna() - 1) < 0 ? logika.getKolumn() - 1 : (glowa.getKolumna() - 1),
                            glowa.getWiersz());
                    break;
                case W_PRAW:
                    tempGlowa = new Para((glowa.getKolumna() + 1) >= logika.getKolumn() ? 0 : (glowa.getKolumna() + 1),
                            glowa.getWiersz());
                    break;
            }

            int wartosPola = logika.isZajęte(tempGlowa.getKolumna(), tempGlowa.getWiersz());

            if (wartosPola != 0) {
                if (wartosPola == numer) {
                    this.zatakowany(tempGlowa);
                } else {
                    logika.getRobaczek(wartosPola).zatakowany(tempGlowa);
                    Mama_just_killed_a_man = true;
                }

            }

            lista.add(glowa);
            logika.dodajNaPole(glowa.getKolumna(), glowa.getWiersz(), numer);

            glowa = tempGlowa;
            logika.dodajNaPole(glowa.getKolumna(), glowa.getWiersz(), numer);


            if (!Mama_just_killed_a_man) {
                Para last = lista.remove(0);
                logika.dodajNaPole(last.getKolumna(), last.getWiersz(), 0);
            }

        }
    }

    public void zatakowany(Para wsp) {
        synchronized (logika) {
            if (wsp.equals(glowa)) {
                //zabicie robaka
                logika.dodajNaPole(glowa.getKolumna(), glowa.getWiersz(), 0);
                glowa = null;

                for (int i = 0; i < lista.size(); i++) {
                    Para temp = lista.get(i);
                    logika.dodajNaPole(temp.getKolumna(), temp.getWiersz(), 0);
                }
                lista.clear();
            } else {
                int index = 0;

                for (int i = 0; i < lista.size(); i++) {
                    logika.dodajNaPole(lista.get(i).getKolumna(),
                            lista.get(i).getWiersz(), 0);

                    if (lista.get(i) == wsp) {
                        index = i;
                        break;
                    }
                }

                List<Para> tempOgon = new ArrayList<>();

                for (int i = index + 1; i < lista.size(); i++) {
                    tempOgon.add(lista.get(i));
                }

                lista = tempOgon;
            }
        }
    }

    @Override
    public void run() {
        while (glowa != null) {
            //
            synchronized (logika) {
                if (glowa != null) {
                    this.ruch();
                }
            }
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Robak.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
