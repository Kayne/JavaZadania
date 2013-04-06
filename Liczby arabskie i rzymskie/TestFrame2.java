/*
  Copyright (c) November 2010 by Pawe� Rzechonek
  Prosta aplikacja okienkowa AWT.
*/

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame
{
    // s�uchacz zdarze� okienkowych jako klasa wewn�trzna dziedzicz�ca po adapterze
    private class MyFrameListener extends WindowAdapter
    {
        public void windowClosing (WindowEvent ev)
        {
            MyFrame.this.dispose();
        }
    };
    private MyFrameListener frameList = new MyFrameListener();

    private Label lab = new Label("this is a label");

    public MyFrame ()
    {
        super("the non-empty frame");
        setSize(300,180);
        setLocation(100,100);
        add(lab);
        lab.setAlignment(Label.CENTER);
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestFrame2
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}
