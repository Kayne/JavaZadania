/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listarosnaca;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.util.ArrayList;
import listarosnaca.stopniewojskowe.Stopnie;

/**
 *
 * @author kayne
 */
public class ListaRosnaca {
    
    Element głowa;

    class Element implements Comparable<Stopnie> {

        Stopnie wartość;
        Element następny;

        Element(Stopnie dodaj) {
            wartość = dodaj;
            następny = null;
        }

        /**
         * Porównywanie stopni w liście.
         * @param stopien stopień do porównania
         * @return -1 dla mniejszego, 0 dla równego, 1 dla większego
         */
        @Override
        public int compareTo(Stopnie stopien) {
            if (wartość.compareTo(stopien) == -1) {
                return -1;
            }
            else if (wartość.compareTo(stopien) == 1) {
                return 1;
            }
            return 0;
        }
    }
    ArrayList<Element> lista = new ArrayList<>();

    public void dodajElement(Stopnie element) {
        
        if (głowa == null) {
            głowa = new Element(element);
        }
        else
        {
            if (głowa.compareTo(element) == -1)
            {
                Element temp = głowa;
                Element temp2 = null;
                
                while(temp != null && temp.compareTo(element) <= 0)
                {
                    temp2 = temp;
                    temp = temp.następny;
                }
                if (temp == null) {
                    temp = new Element(element);
                    temp2.następny = temp;
                }
                else
                {
                    Element nowy = new Element(element);
                    temp2 = temp.następny;
                
                    temp.następny = nowy;
                    nowy.następny = temp2;
                }
            }
            if (głowa.compareTo(element) == 0)
            {
                Element temp = new Element(element);
                temp.następny = głowa;
                głowa = temp;
            }
            if (głowa.compareTo(element) == 1)
            {
                Element temp = new Element(element);
                temp.następny = głowa;
                głowa = temp;
            }
            
        }
    }

    public Stopnie pobierzElement() {
        Element temp = głowa;
        głowa = głowa.następny;
        return temp.wartość;
    }

    @Override
    public String toString() {
        String output = "Elementy:";
        Element temp = głowa;
        while(temp != null) {
            output += temp.wartość + " ";
            temp = temp.następny;
        }
        return output;
    }

    private void usuńNajmniejszyElement() {
        lista.remove(0);
    }
}
