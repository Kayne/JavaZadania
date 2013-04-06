import java.awt.*;
import java.awt.event.*;
import narzedzia.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

/**
* Ramka :)
* @author kayne
**/
class MyFrame extends Frame
{
    private static Dialog d;
    Frame window = new Frame();
    RzymArab konwersja = new RzymArab();
    Pattern pat;
    Matcher mat;
    Rzym2ArabLogger logger = new Rzym2ArabLogger();

    /**
    * Obsługa zamknięcia okna
    **/
    private WindowListener frameList = new WindowAdapter()
    {
        /**
        * Kiedy zamyka się okienko
        **/
        public void windowClosing (WindowEvent ev)
        {
            MyFrame.this.dispose();
            window.dispose();
            logger.writeInfo("Program zamknięto.");
        }
    };

    /**
    * Wyświetla Dialog z odpowiednim tekstem
    **/
    private void show_dialog(String error)
    {
        d = new Dialog(window, "Wystapil blad!", true);
        Dimension dim = getToolkit().getScreenSize();
        Rectangle abounds = getBounds();
        d.setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
        d.setLayout( new FlowLayout() );
        Button ok = new Button ("OK, rozumiem");
        ok.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                MyFrame.d.setVisible(false);
            }
        });
        d.add(new Label(error));
        d.add(ok);
        d.pack();
        d.setVisible(true);
    }

    /**
    * Obsługa lewego pola
    **/
    private ActionListener westListen = new ActionListener()
    {
        public void actionPerformed (ActionEvent ev)
        {
            liczArab2Rzym();
        }
    };

    /**
    * Obsługa prawego pola
    **/
    private ActionListener eastListen = new ActionListener()
    {
        public void actionPerformed (ActionEvent ev)
        {
            liczRzym2Arab();
        }
    };

    /**
    * Obsługa focusa lewego pola
    **/
    private FocusListener focusWest = new FocusListener()
    {
        public void focusLost (FocusEvent ev) {
            west.setText("");
        }
        public void focusGained (FocusEvent ev) {
        }
    };

    /**
    * Obsługa focusa prawego pola
    **/
    private FocusListener focusEast = new FocusListener()
    {
        public void focusLost (FocusEvent ev) {
            east.setText("");
        }
        public void focusGained (FocusEvent ev) {
        }
    };

    /**
    * Licz arabską do rzymskiej
    **/
    private void liczArab2Rzym() {
        try {
            logger.writeInfo("Rozpoczęto konwersję na liczbę rzymską.");
            pat = Pattern.compile("[0-9]*");
            mat = pat.matcher(west.getText());
            if (mat.matches()) {
                logger.writeInfo("Format liczby poprawny, trwa konwersja.");
                int zrodlo = Integer.parseInt(west.getText());
                if (zrodlo < 1 || zrodlo > 3999) {
                    throw new WyjatekKonwersji("Liczba nie miesci sie w przedziale od 1 do 3999!");
                }
                String koniec = konwersja.arab2rzym(zrodlo);
                logger.writeInfo("Wynik konwersji zapisywany do prawego pola.");
                east.setText(koniec);
            }
            else {
                throw new WyjatekKonwersji("Nieprawidlowa liczba!");
            }
            east.requestFocus();
            east.selectAll();
            logger.writeInfo("Zakończono konwersję na liczbę rzymską.");
        }
        catch (WyjatekKonwersji ex) {
            show_dialog(ex.toString());
            logger.writeSevere(ex.toString());
            west.requestFocus();
        }
        catch (NumberFormatException ex) {
            show_dialog(ex.toString());
            logger.writeSevere(ex.toString());
            east.requestFocus();
        }
    }

    /**
    * Licz rzymską do arabskiej
    **/
    private void liczRzym2Arab() {
        try {
            logger.writeInfo("Rozpoczęto konwersję na liczbę arabską.");
            pat = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
            mat = pat.matcher(east.getText());
            if (mat.matches()) {
                logger.writeInfo("Format liczby poprawny, trwa konwersja.");
                String koniec = Integer.toString(konwersja.rzym2arab(east.getText()));
                logger.writeInfo("Wynik konwersji zapisywany do lewego pola.");
                west.setText(koniec);
            }
            else {
                throw new WyjatekKonwersji("Nieprawidlowa liczba!");
            }
            west.requestFocus();
            west.selectAll();
            logger.writeInfo("Zakończono konwersję na liczbę arabską.");
        }
        catch (WyjatekKonwersji ex) {
            show_dialog(ex.toString());
            logger.writeSevere(ex.toString());
            east.requestFocus();
        }
        catch (NumberFormatException ex) {
            show_dialog(ex.toString());
            logger.writeSevere(ex.toString());
            east.requestFocus();
        }
    }

    private TextField west = new TextField("1", 20);
    private TextField east = new TextField("I", 20);

    /**
    * Wyśrodkuj rysowane okno
    **/
    private void setCenteredLocation()
    {
        Dimension dim = getToolkit().getScreenSize();
        Rectangle abounds = getBounds();
        setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
    }

    /**
    * Konstruktor okna
    **/
    public MyFrame ()
    {
        super("Konwerter liczb rzymskich i arabskich");
        logger.writeInfo("Program uruchumiono.");
        setSize(450,60);
        setCenteredLocation();
        setLayout(new GridLayout(1,2));
        add(west);
        add(east);
        addWindowListener(frameList);
        west.addActionListener(westListen);
        east.addActionListener(eastListen);
        west.addFocusListener(focusWest);
        east.addFocusListener(focusEast);
        setVisible(true);
    }
}

/**
* Program :)
* @author kayne
**/
public class Rzym2Arab
{
    /**
    * Główna funkcja
    **/
    public static void main (String[] args)
    {
        try {
            MyLogger.setup();
        }
        catch (IOException ex) {
            System.out.println("Plik z logami programu nie mogl zostac utworzony!");
        }
        new MyFrame();
    }
}