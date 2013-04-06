/*
  Copyright (c) November 2010 by Paweł Rzechonek
  Prosta aplikacja okienkowa AWT z menadżerem rozkładu FlowLayout.
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

    private Label lab = new Label("this is a label");
    private Button but = new Button("this is a button");
    private TextField tex = new TextField("this is a text field");

    public MyFrame ()
    {
        super("the frame with FlowLayout");
        setSize(300,180);
        setLocation(100,100);
        setLayout(new FlowLayout());    // FlowLayout (the defaul layout for Panel)
        add(lab);
        add(but);
        add(tex);
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestLayoutFlowLayout
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}
