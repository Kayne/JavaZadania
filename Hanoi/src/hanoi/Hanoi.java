/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;

/**
 *
 * @author kayne
 */
public class Hanoi extends JApplet {

    int krazki = 4;
    int[][] hanoi = new int[3][krazki];

    private int getNumer(char A) {
        if (A == 'A') {
            return 0;
        }
        if (A == 'B') {
            return 1;
        }
        if (A == 'C') {
            return 2;
        }
        throw new IllegalArgumentException("Nieprawidłowa nazwa krążka!");
    }

    @Override
    public void init() {// metoda przy Aplecie
        setSize(600, 300);// rozmiar okna Appletu
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < krazki; j++) {
                hanoi[i][j] = 0;
            }
        }
        for (int i = 0; i < krazki; i++) {
            hanoi[0][i] = krazki - i;
        }
    }

    @Override
    public void paint(Graphics g) {
        Hanoi(krazki, 'A', 'B', 'C', g);
    }

    private void Hanoi(int n, char A, char B, char C, Graphics g) {
        boolean koniec = false;

        if (n > 0) {
            Hanoi(n - 1, A, C, B, g);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hanoi.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = krazki - 1; i >= 0; i--) {
                if (hanoi[getNumer(A)][i] == 0) {
                    continue;
                }
                for (int j = krazki - 1; j >= 0; j--) {
                    if (hanoi[getNumer(C)][j] == 0 && j > 0) {
                        continue;
                    }
                    if (hanoi[getNumer(C)][j] != 0) {
                        j++;
                    }

                    hanoi[getNumer(C)][j] = hanoi[getNumer(A)][i];
                    hanoi[getNumer(A)][i] = 0;
                    koniec = true;
                    break;
                }
                if (koniec) {
                    break;
                }
            }
            rysujDrzewo(g);

            Hanoi(n - 1, B, A, C, g);
        }
    }

    private void rysujDrzewo(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 600, 600);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < krazki; j++) {

                if (hanoi[i][j] == 0) {
                    break;
                }
                g.setColor(new Color(255 / hanoi[i][j], 0, 255 / hanoi[i][j]));
                g.fillOval((i + 1) * 130, 100, (hanoi[i][j] * 20), (hanoi[i][j] * 20));
            }
        }
    }
}
