/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.util.Random;

/**
 *
 * @author kayne
 */
class Logika {

    private int[][] plansza = new int[22][22];
    private int wygrywające_pole_kolumna = 0;
    private int wygrywające_pole_wiersz = 0;
    private int kierunek = 0; // 1 w prawo, 2 w dół, 3 na skos w prawo, 4 na skos w lewo
    private int wiersz_wolnego_pola = 0;

    Logika() {
        wyczyśćPlanszę();
    }

    /**
     * Czyści planszę, zerując ją.
     */
    public void wyczyśćPlanszę() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                plansza[i][j] = 0;
            }
        }
    }

    /**
     * Zwraca całą planszę.
     *
     * @return plansza
     */
    public int[][] getPlansza() {
        return plansza;
    }

    /**
     * Zwraca wartość konkretnego pola.
     *
     * @param i kolumna pola
     * @param j wiersz pola
     * @return wartość pola
     */
    public int getPoleZPlanszy(int i, int j) {
        return plansza[i][j];
    }

    /**
     * Ustawia wartość pola.
     *
     * @param i kolumna pola
     * @param j wiersz pola
     * @param w wartość pola
     */
    public void setPoleNaPlanszy(int i, int j, int w) {
        plansza[i][j] = w;
    }

    /**
     * Ustawia w której kolumnie jest wygrywające pole.
     *
     * @param pole kolumna
     */
    public void setWygrywającePoleKolumna(int pole) {
        wygrywające_pole_kolumna = pole;
    }

    /**
     * Zwraca wygrywającą kolumnę.
     *
     * @return wygrywająca kolumna
     */
    public int getWygrywającePoleKolumna() {
        return wygrywające_pole_kolumna;
    }

    /**
     * Ustawia wygrywający wiersz.
     *
     * @param pole wygrywający wiersz
     */
    public void setWygrywającePoleWiersz(int pole) {
        wygrywające_pole_wiersz = pole;
    }

    /**
     * Zwraca wygrywający wiersz.
     *
     * @return wygrywający wiersz
     */
    public int getWygrywającePoleWiersz() {
        return wygrywające_pole_wiersz;
    }

    /**
     * Ustawia który kierunek jest wygrywający. 1 - w prawo 2 - w dół 3 - w
     * prawo skos 4 - w lewo skos
     *
     * @param kier liczba reprezentująca kierunek
     */
    public void setKierunek(int kier) {
        kierunek = kier;
    }

    /**
     * Zwraca który kierunek jest wygrywający. 1 - w prawo 2 - w dół 3 - w prawo
     * skos 4 - w lewo skos
     *
     * @return liczba reprezentująca kierunek
     */
    public int getKierunek() {
        return kierunek;
    }

    /**
     * Sprawdza, czy w kolumnie jest ułożenie zwycięskie.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @return prawda lub fałsz
     */
    private boolean sprawdźKolumnę(int kolumna, int wiersz) {
        return sprawdźKolumnę(kolumna, wiersz, 5);
    }

    /**
     * Sprawdza, czy w kolumnie jest ułożenie zwycięskie.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @param pól ile pól potrzeba do zwycięstwa
     * @return prawd lub fałsz
     */
    private boolean sprawdźKolumnę(int kolumna, int wiersz, int pól) {
        int poprz = 0;
        for (int i = wiersz; i < wiersz + pól; i++) {
            if (i >= 21) {
                return false;
            }
            if (poprz == 0) {
                poprz = plansza[kolumna][i];
                continue;
            }
            if (poprz != plansza[kolumna][i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdza, czy w wierszu jest ułożenie zwycięskie.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @return prawda lub fałsz
     */
    private boolean sprawdźWiersz(int kolumna, int wiersz) {
        return sprawdźWiersz(kolumna, wiersz, 5);
    }

    /**
     * Sprawdza, czy w wierszu jest ułożenie zwycięskie.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @param pól ile pól potrzeba do zwycięstwa
     * @return prawda lub fałsz
     */
    private boolean sprawdźWiersz(int kolumna, int wiersz, int pól) {
        int poprz = 0;
        for (int i = kolumna; i < kolumna + pól; i++) {
            if (i >= 21) {
                return false;
            }
            if (poprz == 0) {
                poprz = plansza[i][wiersz];
                continue;
            }
            if (poprz != plansza[i][wiersz]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdza, czy skos w prawo jest ułożeniem zwycięskim.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @return prawda lub fałsz
     */
    private boolean sprawdźSkosPrawy(int kolumna, int wiersz) {
        return sprawdźSkosPrawy(kolumna, wiersz, 5);
    }

    /**
     * Sprawdcza, czy skos prawy jest ułożeniem zwycięskim.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @param pól ile pól potrzeba do zwycięstwa
     * @return prawda lub fałsz
     */
    private boolean sprawdźSkosPrawy(int kolumna, int wiersz, int pól) {
        int poprz = 0;
        for (int i = 0; i < pól; i++) {
            if (kolumna >= 21 || wiersz >= 21) {
                return false;
            }
            if (poprz == 0) {
                poprz = plansza[kolumna++][wiersz++];
                continue;
            }
            if (poprz != plansza[kolumna++][wiersz++]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdź, czy skos lewy jest ułożeniem zwycięskim.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @return prawda lub fałsz
     */
    private boolean sprawdźSkosLewy(int kolumna, int wiersz) {
        return sprawdźSkosLewy(kolumna, wiersz, 5);
    }

    /**
     * Sprawdź, czy skos lewy jest ułożeniem zwycięskim.
     * @param kolumna numer kolumny
     * @param wiersz numer wiersza
     * @param pól ile pól potrzeba do zwycięstwa
     * @return prawda lub fałsz
     */
    private boolean sprawdźSkosLewy(int kolumna, int wiersz, int pól) {
        int poprz = 0;
        for (int i = 0; i < pól; i++) {
            if (kolumna >= 21 || wiersz >= 21 || kolumna <= 0) {
                return false;
            }
            if (poprz == 0) {
                poprz = plansza[kolumna--][wiersz++];
                continue;
            }
            if (poprz != plansza[kolumna--][wiersz++]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdza, kto wygrał rozgrywkę, jeśli znaleziono wygrywające ułożenie.
     * @return 1 dla gracza, 2 dla komputera, 3 dla remisu
     */
    public int sprawdźKtoWygrał() {
        int zajęte_pola = 0;
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (plansza[i][j] != 0) {
                    if (sprawdźKolumnę(i, j)) {
                        setWygrywającePoleKolumna(i);
                        setWygrywającePoleWiersz(j);
                        setKierunek(2);
                        return plansza[i][j];
                    }
                    if (sprawdźWiersz(i, j)) {
                        setWygrywającePoleKolumna(i);
                        setWygrywającePoleWiersz(j);
                        setKierunek(1);
                        return plansza[i][j];
                    }
                    if (sprawdźSkosPrawy(i, j)) {
                        setWygrywającePoleKolumna(i);
                        setWygrywającePoleWiersz(j);
                        setKierunek(3);
                        return plansza[i][j];
                    }
                    if (sprawdźSkosLewy(i, j)) {
                        setWygrywającePoleKolumna(i);
                        setWygrywającePoleWiersz(j);
                        setKierunek(4);
                        return plansza[i][j];
                    }
                    zajęte_pola++;
                }
            }
        }
        if (zajęte_pola == 361) {
            return 3;
        }
        return 0;
    }

    /**
     * Zwraca wolne pole w kolumnie.
     * @return numer kolumny
     */
    private int getWolnePoleKolumna() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(19);
        int randomInt2 = randomGenerator.nextInt(19);
        while (getPoleZPlanszy(randomInt, randomInt2) != 0) {
            randomInt = randomGenerator.nextInt(19);
            randomInt2 = randomGenerator.nextInt(19);
        }
        wiersz_wolnego_pola = randomInt2;
        return randomInt;
    }

    /**
     * Wykonuje ruch komputerem.
     * @param poprzednie integer poprzednie pole
     * @param poprzednie_dwa integer poprzednie pole skośne
     * @param i integer kolumna
     * @param j integer wiersz
     * @param ruch boolean czy ruch został wykonany
     * @param pól integer ile pól ma szukać w algorytmie
     * @return prawda lub fałsz
     */
    public boolean wykonajRuchKomputera(int poprzednie, int poprzednie_dwa, int i, int j, boolean ruch, int pól) {
        if (sprawdźKolumnę(i, j, pól)) {
            if (j - 1 < 0) {
                poprzednie = 0;
            } else {
                poprzednie = j - 1;
            }
            if (getPoleZPlanszy(i, poprzednie) == 0) {
                setPoleNaPlanszy(i, poprzednie, 2);
                ruch = true;
            } else {
                if (j + pól >= 19) {
                    return false;
                }
                if (getPoleZPlanszy(i, j + pól) == 0) {
                    setPoleNaPlanszy(i, j + pól, 2);
                    ruch = true;
                }
            }
        } else if (sprawdźWiersz(i, j, pól)) {
            if (i - 1 < 0) {
                poprzednie = 0;
            } else {
                poprzednie = i - 1;
            }
            if (getPoleZPlanszy(poprzednie, j) == 0) {
                setPoleNaPlanszy(poprzednie, j, 2);
                ruch = true;
            } else {
                if (i + pól >= 19) {
                    return false;
                }
                if (getPoleZPlanszy(i + pól, j) == 0) {
                    setPoleNaPlanszy(i + pól, j, 2);
                    ruch = true;
                }
            }
        } else if (sprawdźSkosPrawy(i, j, pól)) {
            if (i - 1 < 0) {
                poprzednie = 0;
            } else {
                poprzednie = i - 1;
            }
            if (j - 1 < 0) {
                poprzednie_dwa = 0;
            } else {
                poprzednie_dwa = j - 1;
            }

            if (getPoleZPlanszy(poprzednie, poprzednie_dwa) == 0) {
                setPoleNaPlanszy(poprzednie, poprzednie_dwa, 2);
                ruch = true;
            } else {
                if (i + pól >= 19) {
                    return false;
                }
                if (getPoleZPlanszy(i + pól, j + pól) == 0) {
                    setPoleNaPlanszy(i + pól, j + pól, 2);
                    ruch = true;
                }
            }
        } else if (sprawdźSkosLewy(i, j, pól)) {
            if (i - pól < 0) {
                poprzednie = 0;
            } else {
                poprzednie = i - pól;
            }

            if (i + 1 >= 19 || j - 1 < 0) {
                return false;
            }

            if (getPoleZPlanszy(i + 1, j - 1) == 0) {
                setPoleNaPlanszy(i + 1, j - 1, 2);
                ruch = true;
            } else {
                if (j + pól >= 19) {
                    return false;
                }
                if (getPoleZPlanszy(poprzednie, j + pól) == 0) {
                    setPoleNaPlanszy(poprzednie, j + pól, 2);
                    ruch = true;
                }
            }
        }
        return ruch;
    }

    /**
     * Wykonuje ruchy komputerem.
     */
    public void ruchKomputera() {
        int poprzednie = 0;
        int poprzednie_dwa = 0;
        boolean ruch = false;
        for (int i = 1; i <= 20; i++) {
            if (ruch) {
                break;
            }
            for (int j = 1; j <= 20; j++) {
                if (ruch) {
                    break;
                }
                if (plansza[i][j] == 1) {
                    ruch = wykonajRuchKomputera(poprzednie, poprzednie_dwa, i, j, ruch, 4);
                    if (!ruch) {
                        ruch = wykonajRuchKomputera(poprzednie, poprzednie_dwa, i, j, ruch, 3);
                    }
                    if (!ruch) {
                        ruch = wykonajRuchKomputera(poprzednie, poprzednie_dwa, i, j, ruch, 2);
                    }
                }
            }
        }
        if (ruch == false) {
            setPoleNaPlanszy(getWolnePoleKolumna(), wiersz_wolnego_pola, 2);
        }
    }
}
