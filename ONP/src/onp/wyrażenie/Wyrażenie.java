/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp.wyrażenie;

import java.util.Stack;
import onp.funkcje.*;
import onp.wyjątki.*;

/**
 *
 * @author kayne
 */
public class Wyrażenie {
    private Kolejka kolejka; // kolejka symboli wyrażenia ONP (elementy typu Symbol)
    private Stack<Double> stos = new Stack<Double>(); // stos z wynikami pośrednimi obliczeń (elementy typu double)
    private Lista zmienne; // lista zmiennych czyli pary klucz-wartość (String-double)
    
    public Wyrażenie (String onp, Lista zm) throws WyjątekONP {
        
        String wejscie = onp + " =";
        
        double a = 0;//przechowuje dane ze stosu
        double b = 0;//przechowuje dane ze stosu
        double w = 0;//wynik operacji arytmetycznej
        
        String buduj = "";
        String spacja = " ";
        
        char sp = ' ';
        int licznik = 0;
        
        do { //Krok 1: Czytaj el z we
            char czar = wejscie.charAt(licznik);
            if (czar=='+' || czar == '-' || czar == '*' || czar == '/' || czar == '^') { //Krok 2: Jeśli el nie jest liczbą, to idź do kroku 5 
                if(!stos.empty()) {
                    b = stos.pop();//Krok 6: Pobierz ze stosu dwie liczby a i b
                    a = stos.pop();
                    if (czar == '+') { w = new Dodaj(a, b).obliczWartość(); }//Krok 7: Wykonaj nad liczbami a i b operację określoną przez el i umieść wynik w w
                    else if (czar=='-') { w = new Odejmij(a, b).obliczWartość(); }
                    else if (czar=='*') { w = new Mnóż(a,b).obliczWartość(); }
                    else if (czar=='/') { w = new Dziel(a, b).obliczWartość(); }
                    else if (czar=='^')
                    {
                        if (b==0) { 
                            w=1; 
                        } 
                        else {
                            w = a;
                            int licz=1;
                            while (licz < (int)b) {
                                w *= w;
                                licz++;
                            }
                        }
                    }
                    stos.push(w);//Krok 8: Umieść w na stosie
                }
            }
            else if(czar == sp)//Krok 3: Umieść el na stosie 
            {
                if (buduj.compareTo("") != 0) {
                    
                    double tmp = Double.parseDouble(buduj);
                    stos.push(tmp);
                    buduj="";
                }
            }
            else if (czar == '=')//Krok 5: Jeśli el jest znakiem '=', to idź do kroku 10
            {
                if (!stos.empty()) {
                    w = stos.pop();//Krok 10: Prześlij na wyjście zawartość wierzchołka stosu
                    break;
                }
            }
            else if (czar >= '0' && czar <= '9')//buduj liczbe
            {
                buduj += czar;
            }
            else {
                double tmp = zm.getWartośćZmiennej(czar);
                if (tmp != 0)
                {
                    buduj += tmp;
                }
            }
            licznik++;
        } while(licznik < wejscie.length());//Krok 4: Idź do kroku 1
        System.out.println(w);
    }
}

class Kolejka {
}