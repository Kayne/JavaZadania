/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniwersalnykalendarz;

import java.util.GregorianCalendar;
import javax.swing.AbstractListModel;

/**
 *
 * @author kayne
 */
public class Model extends AbstractListModel {
    
    private int rok;
    private int miesiąc;
    
    private String[] monthOfTheYear = new String[]{"Stycznia", "Lutego", "Marca", "Kwietnia", "Maja", "Czerwca", "Lipca", "Sierpnia", "Wrzesnia", "Października", "Listopada", "Grudnia"};
    private String[] daysOfTheWeek = new String[]{"Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota"};

    
    public Model(int r, int m) {
        if (m < 0) {
            m = 11;
            r -= 1;
        }
        if (m > 11) {
            m = 0;
            r += 1;
        }
        rok = r;
        miesiąc = m;
    }
    
    public void zmieńDatę(int r, int m) {
        if (m < 0) {
            m = 11;
            r -= 1;
        }
        if (m > 11) {
            m = 0;
            r += 1;
        }
        rok = r;
        miesiąc = m;
        fireContentsChanged(this, 0, getSize());
    }

    @Override
    public int getSize() {
        GregorianCalendar data = new GregorianCalendar();
        data.set(rok, miesiąc, 1);
        return daysInMonth(data);
    }

    @Override
    public Object getElementAt(int index) {
        GregorianCalendar data = new GregorianCalendar();
        data.set(rok, miesiąc, index+1);
        return daysOfTheWeek[data.get(GregorianCalendar.DAY_OF_WEEK)-1] + ", " + (index+1) + " " + monthOfTheYear[data.get(GregorianCalendar.MONTH)];
    }
    
    private static int daysInMonth(GregorianCalendar c) {
        final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonths[1] += c.isLeapYear(c.get(GregorianCalendar.YEAR)) ? 1 : 0;
        return daysInMonths[c.get(GregorianCalendar.MONTH)];
    }
}
