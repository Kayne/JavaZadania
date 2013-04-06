/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author kayne
 */
public class PanelRysunek extends javax.swing.JPanel implements MouseMotionListener, Serializable {

    private BufferedImage Rysunek;
    private BufferedImage RysunekSzarość;
    private Program rodzic;
    private boolean rysuj = false;
    private Color bieżący_kolor = Color.black;
    private int skala = 1;
    
    /**
     * Aktualne bieżące narzędzie, z typu wyliczeniowego.
     */
    public Narzedzia bieżąceNarzędzie = Narzedzia.OŁÓWEK;
    private Integer stare_x = null;
    private Integer stare_y = null;
    private Integer nowe_x = null;
    private Integer nowe_y = null;
    private boolean szarość = false;
    private boolean zapełnijFigurę = false;

    /**
     * Creates new form PanelRysunek
     */
    public PanelRysunek() {
        initComponents();
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (Rysunek == null) {
            utwórzRysunek();
        }

        if (szarość == true) {
            g.drawImage(getRysunekWSzarości(), 0, 0, Rysunek.getWidth() * skala, Rysunek.getHeight() * skala, this);
        } else {
            g.drawImage(Rysunek, 0, 0, Rysunek.getWidth() * skala, Rysunek.getHeight() * skala, this);
        }

        g.setColor(bieżący_kolor);
        rysujCieńOkręgu(g);
        rysujCieńProstokątu(g);
    }

    /**
     * Rysuje cień okręgu, podczas rysowania, aby wiedzieć jak obecnie on wygląda.
     * @param g obiekt na którym rysujemy
     */
    private void rysujCieńOkręgu(Graphics g) {
        if (bieżąceNarzędzie == Narzedzia.KOŁO && rysuj == true) {
            g.drawOval(stare_x, stare_y, nowe_x, nowe_y);
        }
    }

    /**
     * Rysuje cień prostokątu, podczas rysowania, aby wiedzieć jak obecnie on wygląda.
     * @param g obiekt na którym rysujemy
     */
    private void rysujCieńProstokątu(Graphics g) {
        if (bieżąceNarzędzie == Narzedzia.PROSTOKĄT && rysuj == true) {
            g.drawRect(stare_x, stare_y, nowe_x, nowe_y);
        }
    }

    /**
     * Konwertuje i zwraca rysunek w odcieniach szarości.
     * @return rysunek w szarości typu BufferedImage
     */
    private BufferedImage getRysunekWSzarości() {
        RysunekSzarość = new BufferedImage(Rysunek.getWidth(), Rysunek.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g2 = RysunekSzarość.getGraphics();
        g2.drawImage(Rysunek, 0, 0, Rysunek.getWidth() * skala, Rysunek.getHeight() * skala, this);
        g2.dispose();
        return RysunekSzarość;
    }
    
    /**
     * Rysuje duży biały prostokąt zakrywający całą planszą.
     * @param g obiekt na którym rysujemy
     * @param rysunek rysunek aby pobrać jego wymiary
     */
    private void wypełnijTłoBiałym(Graphics g, BufferedImage rysunek) {
        g.setColor(Color.white);
        g.fillRect(0, 0, rysunek.getWidth(), rysunek.getHeight());
    }

    /**
     * Wczytuje rysunek z pliku i zapisuje do zmiennej.
     * @param rys plik, który otwieramy
     * @throws IOException 
     */
    public void utwórzRysunek(File rys) throws IOException {
        try {
            Rysunek = ImageIO.read(rys);
        } catch (java.awt.color.CMMException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, "Nieprawidłowy format zdjęcia!", ex);
        }
        repaint();
        ustalRozmiaryNaToolBarze();
    }

    /**
     * Wczytuje rysnek z zmiennej do innej zmiennej.
     * @param rys rysunek typu BufferedImage
     */
    public void utwórzRysunek(BufferedImage rys) {
        Rysunek = rys;
        repaint();
    }

    /**
     * Tworzy nowy rysunek i zapełnia domyślnym tłem.
     */
    public void utwórzRysunek() {
        Rysunek = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = Rysunek.getGraphics();
        wypełnijTłoBiałym(g, Rysunek);
        g.dispose();
        repaint();
        ustalRozmiaryNaToolBarze();
    }

    /**
     * Zmienia rozmiary rysunku oraz panelu na którym jest rysowany, z uwzględnieniem pasków przewijania.
     * @param width szerokość nowego rozmiaru
     * @param height wysokość nowego rozmiaru
     */
    public void zmieńRozmiaryRysunka(int width, int height) {
        BufferedImage nowe = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = nowe.getGraphics();
        wypełnijTłoBiałym(g, nowe);
        g.drawImage(Rysunek, 0, 0, null);
        g.dispose();
        Rysunek = nowe;
        zmieńRozmiarPaneluByUstawićPaskiPrzewijania(width, height);
        repaint();
    }
    
    /**
     * Zmienia rozmiar panelu, dzięki czemu poprawnie zachowują się paski przewijania.
     * @param width szerokość rysunku
     * @param height wysokość rysunku
     */
    private void zmieńRozmiarPaneluByUstawićPaskiPrzewijania(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        revalidate();
    }

    /**
     * Ustawia odpowiednie wartości w spinnerach na toolbarze.
     */
    private void ustalRozmiaryNaToolBarze() {
        rodzic.getSpinnerSzerokośćPłótna().setValue(Rysunek.getWidth());
        rodzic.getSpinnerWysokośćPłótna().setValue(Rysunek.getHeight());
    }

    /**
     * Ustawia referencję do „rodzica”.
     * @param parent wskaźnik do rodzica
     */
    public void setRodzic(Program parent) {
        rodzic = parent;
    }

    /**
     * Zwraca referencję do rysunku.
     * @return rysunek typu BufferedImage
     */
    public BufferedImage getRysunek() {
        return Rysunek;
    }

    /**
     * Ustawia bieżący kolor na podany w argumencie.
     * @param kolor kolor typu Color
     */
    public void setBieżącyKolor(Color kolor) {
        bieżący_kolor = kolor;
    }

    /**
     * Zwraca bieżący kolor.
     * @return kolor typu Color
     */
    public Color getBieżącyKolor() {
        return bieżący_kolor;
    }

    /**
     * Rysuje linię na obrazku o kolorze bieżącego koloru.
     * @param x początkowy punkt w osi rzędnych
     * @param y początkowy punkt w osi odciętych
     * @param width końcowy punkt w osi rzędnych
     * @param height końcowy punkt w osi odciętych
     */
    private void narysujLinię(int x, int y, int width, int height) {
        Graphics g = Rysunek.getGraphics();
        g.setColor(bieżący_kolor);
        g.drawLine(x / skala, y / skala, width / skala, height / skala);
    }

    /**
     * Rysuje prostokąt z wypełnieniem lub bez na obrazku o kolorze bieżącego koloru.
     * @param x początkowy punkt w osi rzędnych
     * @param y początkowy punkt w osi odciętych
     * @param width końcowy punkt w osi rzędnych
     * @param height końcowy punkt w osi odciętych
     */
    private void narysujProstokąt(int x, int y, int width, int height) {
        Graphics g = Rysunek.getGraphics();
        g.setColor(bieżący_kolor);
        if (getZapełnijFigurę()) {
            g.fillRect(x / skala, y / skala, width / skala, height / skala);
        } else {
            g.drawRect(x / skala, y / skala, width / skala, height / skala);
        }
    }

    /**
     * Rysuje owal z wypełnieniem lub bez na obrazku o kolorze bieżącego koloru.
     * @param x początkowy punkt w osi rzędnych
     * @param y początkowy punkt w osi odciętych
     * @param width końcowy punkt w osi rzędnych
     * @param height końcowy punkt w osi odciętych
     */
    private void narysujKoło(int x, int y, int width, int height) {
        Graphics g = Rysunek.getGraphics();
        g.setColor(bieżący_kolor);
        if (getZapełnijFigurę()) {
            g.fillOval(x / skala, y / skala, width / skala, height / skala);
        } else {
            g.drawOval(x / skala, y / skala, width / skala, height / skala);
        }

    }

    /**
     * Ustawia bieżące narzędzie na zadane w argumencie.
     * @param narzędzie narzędzie typu wyliczeniowego Narzędzie
     */
    public void setBieżąceNarzędzie(Narzedzia narzędzie) {
        bieżąceNarzędzie = narzędzie;
    }

    /**
     * Zwiększa powiększenie obrazka o 1 za każdym kliknięciem, aż do 8.
     */
    public void zwiększSkalę() {
        if (skala <= 8) {
            skala++;
        }
        repaint();
        zmieńRozmiarPaneluByUstawićPaskiPrzewijania(Rysunek.getWidth()*skala, Rysunek.getHeight()*skala);
    }

    /**
     * Zmniejsza powiększenie obrazka o 1 za każdym kliknięciem, aż do bazowego
     * 1.
     */
    public void zmniejszSkalę() {
        zmieńRozmiarPaneluByUstawićPaskiPrzewijania(Rysunek.getWidth()/skala, Rysunek.getHeight()/skala);
        if (skala > 1) {
            skala--;
        }
        repaint();
    }

    /**
     * Zwraca prawdę, jeśli obrazek jest w odcieniach szarości.
     * @return true lub false
     */
    public boolean getOdcieńSzarości() {
        return szarość;
    }

    /**
     * Ustawia przełącznik, że obrazek jest lub nie jest w odcieniach szarości.
     * @param opcja prawda lub fałsz na pożądaną opcję
     */
    public void setOdcieńSzarości(boolean opcja) {
        szarość = opcja;
    }

    /**
     * Zwraca prawdę jeśli należy zapełniać figurę.
     * @return prawda lub fałsz
     */
    public boolean getZapełnijFigurę() {
        return zapełnijFigurę;
    }

    /**
     * Ustawia przełącznik zapełnienia figury.
     * @param opcja prawda lub fałsz
     */
    public void setZapełnijFigurę(boolean opcja) {
        zapełnijFigurę = opcja;
    }

    /**
     * Zwraca szerokość rysunku.
     * @return szerokość rysunku
     */
    public int getRysunekWidth() {
        return Rysunek.getWidth();
    }

    /**
     * Zwraca wysokość rysunku.
     * @return wysokość rysunku
     */
    public int getRysunekHeight() {
        return Rysunek.getHeight();
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        rysuj = true;
        if (bieżąceNarzędzie == Narzedzia.KOŁO) {
            if (stare_x == null) {
                stare_x = evt.getX();
            }
            if (stare_y == null) {
                stare_y = evt.getY();
            }
        }
        if (bieżąceNarzędzie == Narzedzia.PROSTOKĄT) {
            if (stare_x == null) {
                stare_x = evt.getX();
            }
            if (stare_y == null) {
                stare_y = evt.getY();
            }
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        rysuj = false;
        if (bieżąceNarzędzie == Narzedzia.KOŁO) {
            narysujKoło(stare_x, stare_y, nowe_x, nowe_y);
            repaint();
        }
        if (bieżąceNarzędzie == Narzedzia.PROSTOKĄT) {
            narysujProstokąt(stare_x, stare_y, nowe_x, nowe_y);
            repaint();
        }
        stare_x = null;
        stare_y = null;

    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (rysuj != false) {
            switch (bieżąceNarzędzie) {
                case OŁÓWEK:
                    if (stare_x == null) {
                        stare_x = e.getX();
                    }
                    if (stare_y == null) {
                        stare_y = e.getY();
                    }
                    narysujLinię(stare_x, stare_y, e.getX(), e.getY());
                    stare_x = e.getX();
                    stare_y = e.getY();
                    break;
                case KOŁO:
                case PROSTOKĄT:
                    nowe_x = e.getX() - stare_x;
                    nowe_y = e.getY() - stare_y;
                    break;
            }
            repaint();
        }
    }
}
