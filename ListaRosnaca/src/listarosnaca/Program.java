/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listarosnaca;
import listarosnaca.stopniewojskowe.*;

/**
 *
 * @author kayne
 */
public class Program {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaRosnaca żołnierze = new ListaRosnaca();
        Kapitan kapitan = new Kapitan("Grzesiu Jakiś Tam");
        Szeregowy szeregowy = new Szeregowy("Zwykły Szarak");
        Pulkownik pulkownik = new Pulkownik("Ważny Ktoś");
        żołnierze.dodajElement(szeregowy);
        żołnierze.dodajElement(pulkownik);
        żołnierze.dodajElement(kapitan);
        żołnierze.dodajElement(szeregowy);
        żołnierze.dodajElement(kapitan);
        
        String cos = żołnierze.toString();
        System.out.println(cos);
        
        System.out.println(żołnierze.pobierzElement());
        
        cos = żołnierze.toString();
        System.out.println(cos);
        
        System.out.println(żołnierze.pobierzElement());
        
        cos = żołnierze.toString();
        System.out.println(cos);
        
        System.out.println(żołnierze.pobierzElement());
        
        cos = żołnierze.toString();
        System.out.println(cos);
        
        System.out.println(żołnierze.pobierzElement());
        
        cos = żołnierze.toString();
        System.out.println(cos);
        
        System.out.println(żołnierze.pobierzElement());
        
        cos = żołnierze.toString();
        System.out.println(cos);
        
    }
}
