/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewawyrazen.instrukcje;

/**
 *
 * @author kayne
 */
public class If extends Instrukcja
{
    protected final Instrukcja a1;
    protected final Instrukcja a2;
    protected String w = "";

    public If (Instrukcja a, Instrukcja b, String w) 
    {
        a1 = a;
        a2 = b;
        this.w = w;
    }

    @Override
    public int wykonaj () 
    {
        if (w.compareTo("<") == 0)
        {
            if (a1.wykonaj() < a2.wykonaj())
            {
                return 1;
            }
        }
        else if (w.compareTo(">") == 0)
        {
            if (a1.wykonaj() > a2.wykonaj())
            {
                return 1;
            }
        }
        else if (w.compareTo("<=") == 0)
        {
            if (a1.wykonaj() <= a2.wykonaj())
            {
                return 1;
            }
        }
        else if (w.compareTo(">=") == 0)
        {
            if (a1.wykonaj() >= a2.wykonaj())
            {
                return 1;
            }
        }
        else if (w.compareTo("!=") == 0)
        {
            if (a1.wykonaj() != a2.wykonaj())
            {
                return 1;
            }
        }
        else if (w.compareTo("==") == 0)
        {
            if (a1.wykonaj() == a2.wykonaj())
            {
                return 1;
            }
        }
        return 0;
    }
    
    @Override
    public String toString () 
    {
        return "if (" + String.valueOf(a1) + w + String.valueOf(a2) + ")";
    }
}
