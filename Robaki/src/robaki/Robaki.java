/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robaki;

/**
 *
 * @author kayne
 */
public class Robaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int kolumn, wierszy;

        if (args.length == 2) {
            if (Integer.parseInt(args[0]) + Integer.parseInt(args[1]) > Integer.parseInt(args[0]) * Integer.parseInt(args[1])) {
                kolumn = 10;
                wierszy = 10;
            } else {
                kolumn = Integer.parseInt(args[0]);
                wierszy = Integer.parseInt(args[1]);
            }
        } else {
            kolumn = 10;
            wierszy = 10;
        }

        final Logika logika = new Logika(kolumn, wierszy);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Program(kolumn, wierszy, logika).setVisible(true);
            }
        });

        for (int i = 0; i < kolumn + wierszy; i++) {
            Robak robaczek = new Robak(logika);
            logika.addRobak(robaczek);
            logika.addThread(new Thread(robaczek));
        }

    }
}
