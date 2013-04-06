/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

/**
 *
 * @author kayne
 */
public class Plansza extends javax.swing.JPanel {

    private int player;
    boolean wygrana = false;
    JLabel etykieta;
    Logika logika;
    Ustawienia ustawienia;
    int x, y, x_m, y_m, rozmiar_pionka;
    private final String[] alfabet = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};

    /**
     * Creates new form Plansza
     */
    public Plansza() {
        logika = new Logika();
        logika.wyczyśćPlanszę();
        ustawienia = new Ustawienia();
        initComponents();
    }

    /**
     * Czyści planszę i ją przemalowuje. Plansza gotowa do nowej rozgrywki.
     */
    public void czyśćPlanszęIPrzemaluj() {
        logika.wyczyśćPlanszę();
        logika.setKierunek(0);
        ustalPlanszę();
        odświeżPlanszę();
    }

    /**
     * Ustala, którego gracza jest ruch. Zaczwyczaj pierwszy ruch.
     */
    public void ustalGracza() {
        if (ustawienia.isGraczZaczyna() == true) {
            player = 1;
        } else {
            player = 2;
        }
    }

    /**
     * W zależności od gracza, ustala odpowiednią etykietę.
     */
    public void ustalEtykietę() {
        if (player == 1) {
            etykieta.setText("Ruch gracza… Kliknij na planszy by postawić pionka.");
        } else {
            etykieta.setText("Ruch komputera…");
        }
    }

    /**
     * Ustawia planszę, aby była gotowa do gry.
     */
    public void ustalPlanszę() {
        ustalGracza();
        ustalEtykietę();
        if (ustawienia.isGraczZaczyna() == false) {
            logika.ruchKomputera();
            zmieńGracza();
            ustalEtykietę();
        }
    }

    /**
     * Ustawia wskaźnik na etykietę.
     *
     * @param et wskaźnik na etykietę
     */
    public void setEtykieta(JLabel et) {
        etykieta = et;
    }

    /**
     * Ustawia wskaźnik na ustawienia.
     *
     * @param ust wskaźnik na ustawienia
     */
    public void setUstawienia(Ustawienia ust) {
        ustawienia = ust;
    }

    /**
     * Przemalowuje planszę.
     */
    public void odświeżPlanszę() {
        repaint();
    }

    /**
     * Zmienia na kolejnego gracza.
     */
    private void zmieńGracza() {
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
    }

    /**
     * Ustawia daną liczbę jako rozmiar pionka.
     *
     * @param rozmiar integer
     */
    private void setRozmiarPionka(int rozmiar) {
        rozmiar_pionka = rozmiar;
    }

    /**
     * Zwraca rozmiar pionka.
     *
     * @return integer będący rozmiarem pionka
     */
    private int getRozmiarPionka() {
        return rozmiar_pionka;
    }

    /**
     * Ustala rozmiar pionka, który jest szerokości i wysokości 1/3 długości lub
     * wysokości planszy, w zależności od tego, co jet mniejsze.
     */
    private void ustalRozmiarPionka() {
        if (getWysokośćKwadratu() > getSzerokośćKwadratu()) {
            setRozmiarPionka((int) (getWysokośćKwadratu() * 1 / 3));
        } else {
            setRozmiarPionka((int) (getSzerokośćKwadratu() * 1 / 3));
        }
    }

    /**
     * Zwraca szerokość kwadratu, bazując na szerokości całej planszy.
     *
     * @return integer szerokość pojedynczego kwadratu
     */
    private int getSzerokośćKwadratu() {
        return getWidth() / 21;
    }

    /**
     * Zwraca wysokość kwadratu, bazując na wysokości całej planszy.
     *
     * @return integer wysokość pojedynczego kwadratu
     */
    private int getWysokośćKwadratu() {
        return getHeight() / 21;
    }

    /**
     * Główna funkcja rysująca planszę.
     *
     * @param g1 obiekt Graphics
     */
    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Font font = new Font("Helvetica", Font.PLAIN, getWysokośćKwadratu()/2);
        g.setFont(font);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paint(g);

        rysujPlanszę(g);
        ustalRozmiarPionka();
        rysujPionkiNaPlanszy(g);
        rysujSkreśleniePól(g);
    }

    /**
     * Funkcja rysująca planszę, wraz z oznaczeniem.
     *
     * @param g obiekt Graphics2D
     */
    private void rysujPlanszę(Graphics2D g) {
        for (int i = 1; i <= 20; i++) {
            if (ustawienia.isOznaczeniePól()) {
                if (i < 20) {
                    g.setColor(ustawienia.getKolorOznaczeniaPól());
                    Font font = new Font("Helvetica", Font.PLAIN, 12);
                    g.setFont(font);
                    g.drawString(alfabet[i], i * getSzerokośćKwadratu() + getSzerokośćKwadratu() / 2, getWysokośćKwadratu() - 5);
                    g.drawString(alfabet[i], i * getSzerokośćKwadratu() + getSzerokośćKwadratu() / 2, getWysokośćKwadratu() - 6);
                    g.drawString(Integer.toString(i), getSzerokośćKwadratu() / 4, i * getWysokośćKwadratu() + getWysokośćKwadratu());
                    g.drawString(Integer.toString(i), getSzerokośćKwadratu() / 4 + 1, i * getWysokośćKwadratu() + getWysokośćKwadratu());
                }
            }
            g.setColor(ustawienia.getKolorPól());
            g.drawLine(i * getSzerokośćKwadratu(), getWysokośćKwadratu(), i * getSzerokośćKwadratu(), 20 * getWysokośćKwadratu());
            g.drawLine(getSzerokośćKwadratu(), i * getWysokośćKwadratu(), 20 * getSzerokośćKwadratu(), i * getWysokośćKwadratu());
        }
    }

    /**
     * Rysuje pionki na planszy zgodnie z ich rozstawieniem na wirtualnej
     * planszy z logiki.
     *
     * @param g obiekt Graphics przekazywany z funkcji paint
     */
    private void rysujPionkiNaPlanszy(Graphics g) {
        /* Rysowanie pionków */
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                g.setColor(ustawienia.getKolorPól());

                switch (logika.getPoleZPlanszy(i, j)) {
                    case 1:
                        g.drawOval(i * getSzerokośćKwadratu() - getRozmiarPionka() / 2, j * getWysokośćKwadratu() - getRozmiarPionka() / 2, getRozmiarPionka(), getRozmiarPionka());
                        g.setColor(ustawienia.getKolorGracza());
                        g.fillOval(i * getSzerokośćKwadratu() - getRozmiarPionka() / 2, j * getWysokośćKwadratu() - getRozmiarPionka() / 2, getRozmiarPionka(), getRozmiarPionka());
                        break;
                    case 2:
                        g.drawOval(i * getSzerokośćKwadratu() - getRozmiarPionka() / 2, j * getWysokośćKwadratu() - getRozmiarPionka() / 2, getRozmiarPionka(), getRozmiarPionka());
                        g.setColor(ustawienia.getKolorKomputera());
                        g.fillOval(i * getSzerokośćKwadratu() - getRozmiarPionka() / 2, j * getWysokośćKwadratu() - getRozmiarPionka() / 2, getRozmiarPionka(), getRozmiarPionka());
                        break;
                }
            }
        }
    }

    /**
     * Rysuje skreślenie pionków.
     *
     * @param g obiekt Graphics przekazywany z funkcji paint
     */
    private void rysujSkreśleniePól(Graphics g) {
        g.setColor(Color.black);
        if (ustawienia.isSkreśleniePól() == true) {
            if (logika.getKierunek() != 0) {
                if (logika.getKierunek() == 1) {
                    x = logika.getWygrywającePoleKolumna() * getSzerokośćKwadratu();
                    y = logika.getWygrywającePoleWiersz() * getWysokośćKwadratu();
                    x_m = (logika.getWygrywającePoleKolumna() + 4) * getSzerokośćKwadratu();
                    y_m = (logika.getWygrywającePoleWiersz()) * getWysokośćKwadratu();
                    g.drawLine(x, y, x_m, y_m);
                    g.drawLine(x, y + 1, x_m, y_m + 1);
                    g.drawLine(x, y - 1, x_m, y_m - 1);
                } else if (logika.getKierunek() == 2) {
                    x = logika.getWygrywającePoleKolumna() * getSzerokośćKwadratu();
                    y = logika.getWygrywającePoleWiersz() * getWysokośćKwadratu();
                    x_m = (logika.getWygrywającePoleKolumna()) * getSzerokośćKwadratu();
                    y_m = (logika.getWygrywającePoleWiersz() + 4) * getWysokośćKwadratu();
                    g.drawLine(x, y, x_m, y_m);
                    g.drawLine(x + 1, y, x_m + 1, y_m);
                    g.drawLine(x - 1, y, x_m - 1, y_m);
                } else if (logika.getKierunek() == 3) {
                    x = logika.getWygrywającePoleKolumna() * getSzerokośćKwadratu();
                    y = logika.getWygrywającePoleWiersz() * getWysokośćKwadratu();
                    x_m = (logika.getWygrywającePoleKolumna() + 4) * getSzerokośćKwadratu();
                    y_m = (logika.getWygrywającePoleWiersz() + 4) * getWysokośćKwadratu();
                    g.drawLine(x, y, x_m, y_m);
                    g.drawLine(x + 1, y, x_m + 1, y_m);
                    g.drawLine(x - 1, y, x_m - 1, y_m);
                } else if (logika.getKierunek() == 4) {
                    x = (logika.getWygrywającePoleKolumna()) * getSzerokośćKwadratu();
                    y = (logika.getWygrywającePoleWiersz()) * getWysokośćKwadratu();
                    x_m = (logika.getWygrywającePoleKolumna() - 4) * getSzerokośćKwadratu();
                    y_m = (logika.getWygrywającePoleWiersz() + 4) * getWysokośćKwadratu();
                    g.drawLine(x, y, x_m, y_m);
                    g.drawLine(x + 1, y, x_m + 1, y_m);
                    g.drawLine(x - 1, y, x_m - 1, y_m);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Przechwytuje kliknięcie, oblicza które pole należy zakolorować i zapisuje
     * do wirtualnej planszy.
     *
     * @param evt
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        int col, row, zwyciestwo;
        col = evt.getX() * 21 / getWidth();
        row = evt.getY() * 21 / getHeight();

        int lewa_kolumna = col * getSzerokośćKwadratu();
        int prawa_kolumna = (col + 1) * getSzerokośćKwadratu();

        int górny_wiersz = row * getWysokośćKwadratu();
        int dolny_wiersz = (row + 1) * getWysokośćKwadratu();

        if ((prawa_kolumna - lewa_kolumna) / 2 < prawa_kolumna - evt.getX()) {
            col = evt.getX() * 21 / getWidth();
        } else {
            col = evt.getX() * 21 / getWidth() + 1;
        }

        if ((dolny_wiersz - górny_wiersz) / 2 < dolny_wiersz - evt.getY()) {
            row = evt.getY() * 21 / getHeight();
        } else {
            row = evt.getY() * 21 / getHeight() + 1;
        }

        if (col > 0 && col < 21 && row > 0 && row < 21) {

            if (logika.getPoleZPlanszy(col, row) == 0) {
                if (player == 1) {
                    logika.setPoleNaPlanszy(col, row, 1);
                    zmieńGracza();
                    ustalEtykietę();
                    zwyciestwo = logika.sprawdźKtoWygrał();
                    if (zwyciestwo != 0) {
                        wygrana = true;
                    } else {
                        logika.ruchKomputera();
                        zmieńGracza();
                        ustalEtykietę();
                    }
                }

                zwyciestwo = logika.sprawdźKtoWygrał();
                if (zwyciestwo != 0) {
                    wygrana = true;
                }

                odświeżPlanszę();

                if (zwyciestwo == 1) {
                    etykieta.setText("Wygrał gracz! Rozpocznij nową grę.");
                } else if (zwyciestwo == 2) {
                    etykieta.setText("Wygrał komputer! Rozpocznij nową grę.");
                } else if (zwyciestwo == 3) {
                    etykieta.setText("Nikt nie wygrał, gra zakończyła się remisem. Rozpocznij nową grę.");
                } else {
                    ustalEtykietę();
                }
            }
        }
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
