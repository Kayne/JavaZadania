/*
  Copyright (c) November 2010 by Paweł Rzechonek
  Prosta aplikacja okienkowa AWT z menadżerem rozkładu BorderLayout.
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

    private Button north = new Button("north side");
    private Button west = new Button("west side");
    private Button center = new Button("center zone");
    private Button east = new Button("east side");
    private Button south = new Button("south side");

    public MyFrame ()
    {
        super("the frame with BorderLayout");
        setSize(300,180);
        setLocation(100,100);
        // setLayout(new BorderLayout());    // BorderLayout (the defaul layout for Frame and Dialog)
        add(north,BorderLayout.NORTH);
        add(west,BorderLayout.WEST);
        add(center,BorderLayout.CENTER); // add(center);
        add(east,BorderLayout.EAST);
        add(south,BorderLayout.SOUTH);
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestLayoutBorderLayout
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}