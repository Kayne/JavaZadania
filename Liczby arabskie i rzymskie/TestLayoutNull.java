/*
  Copyright (c) November 2010 by Paweł Rzechonek
  Prosta aplikacja okienkowa AWT bez menadżera rozkładu.
  Spróbuj zmienić rozmiar okna w czasie działania aplikacji.
*/

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame
{
    private WindowListener frameList = new WindowAdapter()
    {
        public void windowClosing (WindowEvent ev)
        {
            MyFrame.this.dispose();
        }
    };

    private Button but1 = new Button("button1");
    private Button but2 = new Button("button2");
    private Button but3 = new Button("button3");

    public MyFrame ()
    {
        super("the frame with no layout");
        setLayout(null);    // no layout manager
        setSize(300,180);
        setLocation(100,100);
        // każdemu komponentowi wewnętrznemu trzeba określić rozmiar (setSize) i położenie (setLocation)
        add(but1); but1.setSize(100,20); but1.setLocation(50,50);
        add(but2); but2.setSize(200,20); but2.setLocation(250,50);
        add(but3); but3.setSize(400,20); but3.setLocation(50,450);
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestLayoutNull
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}