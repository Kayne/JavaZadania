/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp;
import onp.funkcje.*;
import onp.wyjątki.*;
import onp.wyrażenie.*;

/**
 *
 * @author kayne
 */
public class ONP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WyjątekONP {
        // TODO code application logic here
        try {
            Dziel dzielenie = new Dziel(34,0);
            System.out.println(dzielenie.obliczWartość());
        }
        catch (ONP_DzieleniePrzez0 ex) {
            System.out.println("Dzielenie przez 0 jest niedozwolone!");
        }
        Dodaj dodawanie = new Dodaj(20, 45);
        System.out.println(dodawanie.obliczWartość());
        Zmienna zmienna = new Zmienna("a", 21);
        System.out.println(zmienna.wartość + zmienna.nazwa);
        
        Lista zmienne = new Lista();
        zmienne.dodaj(new Zmienna("a", 45));
        zmienne.dodaj(new Zmienna("b", 5));
        
        Wyrażenie cos = new Wyrażenie("a b +", zmienne);
    }
}
