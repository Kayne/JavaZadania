/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniwersalnykalendarz;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author kayne
 */
public class Kreslarz extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        String s = value.toString();
        setText(s);
        if (s.matches(".*Niedziela.*")) {
            setForeground(Color.red);
        } else {
            setForeground(Color.black);
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
