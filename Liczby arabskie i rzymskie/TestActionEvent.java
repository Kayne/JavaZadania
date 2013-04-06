/*
  Copyright (c) November 2010 by Paweł Rzechonek
  Prosta aplikacja okienkowa AWT - sprawdza poprawność danych
  za pomocą dopasowania do wzorca (sprawdzanie to odbywa się
  w metodzie obsługującej zdarzenie akcji).
*/

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame
{
    // obiekt implementujący interfejs WindowListener dla zdarzeń okienkowych
    private WindowListener frameList = new WindowAdapter()
    {
        public void windowClosing (WindowEvent ev)
        {
            MyFrame.this.dispose();
            System.exit(0);
        }
    };
    // obiekt implementujący interfejs ActionListener dla zdarzeń akcji
    private ActionListener butList = new ActionListener()
    {
        public void actionPerformed (ActionEvent ev)
        {
            if (tex.getText().matches("([-]?[1-9]\\d*)|0"))
                lab.setText(tex.getText()+" is an integer");
            else
                lab.setText(tex.getText()+" isn't an integer");
            tex.requestFocus();
            tex.selectAll();
        }
    };

    private Label lab = new Label("is this an integer?");
    private Button but = new Button("check");
    private TextField tex = new TextField();

    public MyFrame ()
    {
        super("check integers");
        setSize(400,100);
        setLocation(100,100);
        add(lab,BorderLayout.NORTH);
        add(but,BorderLayout.CENTER);
        add(tex,BorderLayout.SOUTH);

        // źródło zdarzenia Button deleguje słuchacza zdarzeń akcji ActionListener
        // do przechwytywania i obsługi zdarzeń akcji pochodzących od tego komponentu
        but.addActionListener(butList);

        // okno aplikacji Frame deleguje słuchacza zdarzeń okienkowych WindowListener
        // do przechwytywania i obsługi zdarzeń okienkowych związanych z tym oknem
        addWindowListener(frameList);

        setResizable(false);
        setVisible(true);
    }
}

public class TestActionEvent
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}
