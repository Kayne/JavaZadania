package julia;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Julia extends JApplet {

    private Zespolona c = new Zespolona(-0.123, 0.745);
    //private Zespolona c = new Zespolona(-0.231, 0.745);
    private double x, y;
    
    int n;

    double xScale;
    double yScale;
    
    @Override
    public void init() {// metoda przy Aplecie
        setSize(600, 600);// rozmiar okna Appletu
    }

    private int generate(double x, double y) {

        Zespolona z0 = new Zespolona(x, y);
        Zespolona zn;

        for (n = 0; n < 30; n++) {

            zn = z0.kwadrat();
            zn = zn.dodaj(c);

            if (zn.getOdleglosc() > 2) {
                break;// oblicza odleg³oœæ dla ka¿dej iteracji, a¿ do odleg³oœci równej r
            }
            z0 = zn;
        }
        return n;
    }

    @Override
    public void paint(Graphics g) {
        // wartoœæ sta³ej liczby rzeczywistej
        //dane to kolejno liczba rzeczywista i urojona

        xScale = 3.0 / 600;
        yScale = 3.0 / 600;

        x = -3.0 * 0.5;
        for (int i = 0; i <= 600; i++) {

            y = -3.0 * 0.5;

            for (int z = 0; z <= 600; z++) {

                int color = generate(x, y);

                g.setColor(new Color(color * 8, 0, 0));
                g.drawLine(i, z, i, z);
                y += yScale;
            }
            x += xScale;
        }
    }
}