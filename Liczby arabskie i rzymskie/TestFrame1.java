/*
  Copyright (c) November 2010 by Pawe� Rzechonek
  Prosta aplikacja okienkowa AWT.
*/

import java.awt.*;
import java.awt.event.*;

// s�uchacz zdarze� okienkowych jako oddzielna klasa
class MyFrameListener implements WindowListener
{
    Frame frame;

    public MyFrameListener (Frame f)
    {
        if (f==null) throw new NullPointerException();
        frame = f;
    }

    public void windowClosing (WindowEvent ev)
    {
        frame.dispose();
    }
    public void windowOpened (WindowEvent ev) {}
    public void windowClosed (WindowEvent ev) {}
    public void windowIconified (WindowEvent ev) {}
    public void windowDeiconified (WindowEvent ev) {}
    public void windowActivated (WindowEvent ev) {}
    public void windowDeactivated (WindowEvent ev) {}
};


class MyFrame extends Frame
{
    private WindowListener frameList = new MyFrameListener(this);

    public MyFrame ()
    {
        super("the empty frame");
        setSize(300,240);
        setLocation(100,100);
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestFrame1
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}