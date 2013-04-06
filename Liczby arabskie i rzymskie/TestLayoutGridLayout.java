/*
  Copyright (c) November 2010 by Paweł Rzechonek
  Prosta aplikacja okienkowa AWT z menadżerem rozkładu GridLayout.
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

    public MyFrame ()
    {
        super("the frame with GridLayout");
        setSize(300,120);
        setLocation(100,100);
        setLayout(new GridLayout(3,5));    // GridLayout with the specified number of rows (the first argument) and columns - rows (the second argument)
        for (int i=0; i<3*5; i++)
            add(new Button("button "+i));
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestLayoutGridLayout
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}