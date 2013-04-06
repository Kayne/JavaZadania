/*
  Copyright (c) November 2010 by Paweł Rzechonek
  Aplikacja okienkowa AWT - prezentuje możliwości klasy Canvas
  w przechwytywaniu zdarzeń od myszy i od klawiatury.
  Aby przechwytywać zdarzenia od klawiatury trzeba najpierw wywołać metodę
  setFocusable(true) na obiekcie Canvas.
*/

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame
{
    private Color kolor = Color.BLACK;

    private WindowListener frameList = new WindowAdapter()
    {
        public void windowClosing (WindowEvent ev)
        {
            MyFrame.this.dispose();
        }
    };
    private MouseListener mouseList = new MouseAdapter()
    {
        public void mouseClicked (MouseEvent ev)
        {
            Graphics gr = can.getGraphics();
            gr.setColor(kolor);
            gr.fillRect(ev.getX()-10,ev.getY()-10,20,20);
        }
    };
    private KeyListener keyList = new KeyAdapter()
    {
        public void keyPressed (KeyEvent ev)
        {
            switch (ev.getKeyCode())
            {
            case KeyEvent.VK_R: // klawisz 'R'
                kolor = Color.RED;
                break;
            case KeyEvent.VK_G: // klawisz 'G'
                kolor = Color.GREEN;
                break;
            case KeyEvent.VK_B: // klawisz 'B'
                kolor = Color.BLUE;
                break;
            default: // inne klawisze
                kolor = Color.BLACK;
                break;
            }
            ;
        }
    };

    private Canvas can = new Canvas();

    public MyFrame ()
    {
        super("coloured squers");
        setSize(400,120);
        setLocation(100,100);
        add(can,BorderLayout.CENTER);
        can.addKeyListener(keyList);
        can.addMouseListener(mouseList);
        can.setFocusable(true);
        can.requestFocus();
        addWindowListener(frameList);
        setVisible(true);
    }
}

public class TestCanvas
{
    public static void main (String[] args)
    {
        new MyFrame();
    }
}
