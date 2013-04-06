/*
  Copyright (c) November 2010 by Pawe� Rzechonek
  Prosta aplikacja okienkowa AWT.
*/

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame
{
    // s�uchacz zdarze� okienkowych jako klasa wewn�trzna anonimowa
    private WindowListener frameList = new WindowAdapter()
    {
        public void windowClosing (WindowEvent ev)
        {
            MyFrame.this.dispose();
        }
    };

    private Label lab = new Label("this is a label");
    private Button but = new Button("this is a button");
    private TextField tex = new TextField("this is a text field");

    public MyFrame ()
    {
        super("the non-empty frame");
        setSize(300,120);
        setLocation(100,100);
        add(lab,BorderLayout.NORTH);
        add(but,BorderLayout.CENTER);
        add(tex,BorderLayout.SOUTH);
        addWindowListener(frameList);
        setResizable(false);
        setVisible(true);
    }
}

public class TestFrame3
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}
