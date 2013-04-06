/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.awt.Color;

/**
 *
 * @author kayne
 */
class Ustawienia {

    private boolean oznaczenie_pól = true;
    private boolean skreślenie_pól = true;
    private boolean gracz_zaczyna = false;
    private boolean zablokowana_plansza = false;
    private Color kolor_gracza = Color.red;
    private Color kolor_komputera = Color.black;
    private Color kolor_pól = Color.black;
    private Color kolor_oznaczenia_pól = Color.black;
    /**
     * Zwraca wartość ustawienia dla Oznaczenia Pól.
     * @return prawda lub fałsz
     */
    public boolean isOznaczeniePól() {
        return oznaczenie_pól;
    }

    /**
     * Zwraca wartość ustawienia dla Skreślenie Pól.
     * @return prawda lub fałsz
     */
    public boolean isSkreśleniePól() {
        return skreślenie_pól;
    }
    
    /**
     * Zwraca wartość ustawienia dla kto zaczyna grę.
     * @return prawda lub fałsz
     */
    public boolean isGraczZaczyna() {
        return gracz_zaczyna;
    }
    
    /**
     * Sprawdza, czy plansza jest zablokowana.
     * @return prawda jeśli zablokowana, fałsz jeśli zablokowana
     */
    public boolean isZablokowanaPlansza() {
        return zablokowana_plansza;
    }
    
    /**
     * Zwraca wartość ustawienia dla koloru gracza.
     * @return kolor dla JChooseColor
     */
    public Color getKolorGracza() {
        return kolor_gracza;
    }
    
    /**
     * Zwraca wartość ustawienia dla koloru komputera.
     * @return kolor dla JChooseColor
     */
    public Color getKolorKomputera() {
        return kolor_komputera;
    }
    
    /**
     * Zwraca wartość ustawienia dla koloru pól.
     * @return kolor dla JChooseColor
     */
    public Color getKolorPól() {
        return kolor_pól;
    }
    
    /**
     * Zwraca wartość ustawienia dla koloru oznaczenia pól.
     * @return kolor dla JChooserColor
     */
    public Color getKolorOznaczeniaPól() {
        return kolor_oznaczenia_pól;
    }
    
    /**
     * Ustawia oznaczenie pól
     * @param opcja prawda dla tak, fałsz dla nie
     */
    public void setOznaczeniePól(boolean opcja) {
        oznaczenie_pól = opcja;
    }
    
    /**
     * Ustawia skreślenia pól
     * @param opcja prawda dla tak, fałsz dla nie
     */
    public void setSkreśleniePól(boolean opcja) {
        skreślenie_pól = opcja;
    }

    /**
     * Ustawia kto zaczyna grę
     * @param opcja prawda dla gracz, fałsz dla komputera
     */
    public void setGraczZaczyna(boolean opcja) {
        gracz_zaczyna = opcja;
    }
    
    public void setZablokowanaPlansza(boolean opcja) {
        zablokowana_plansza = opcja;
    }
    
    /**
     * Ustawia kolor gracza
     * @param kolor kolor z JChooseColor
     */
    public void setKolorGracza(Color kolor) {
        kolor_gracza = kolor;
    }
    
    /**
     * Ustawia kolor komputera
     * @param kolor kolor z JChooseColor
     */
    public void setKolorKomputera(Color kolor) {
        kolor_komputera = kolor;
    }
    
    /**
     * Ustawia kolor pól
     * @param kolor kolor z JChooseColor
     */
    public void setKolorPól(Color kolor) {
        kolor_pól = kolor;
    }
    
    /**
     * Ustawia kolor oznaczenia pól.
     * @param kolor kolor z JChooseColor
     */
    public void setKolorOznaczeniaPól(Color kolor) {
        kolor_oznaczenia_pól = kolor;
    }
}
