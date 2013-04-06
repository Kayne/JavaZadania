/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatoronp;
import java.io.*;
import java.util.Arrays;
import java.util.regex.*;
import kalkulatoronp.narzedzia.*;


/**
 * Kalkulator ONP
 * @author kayne
 */
public class KalkulatorONP {
    
    /**
     * Lista zmiennych
     */
    static Lista lista = new Lista();

    /**
     * @param args the command line arguments
     * @throws IOException  
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        String linia;
	BufferedReader we = new BufferedReader(new InputStreamReader(System.in));
	String zmienneString = " ";

        do {
            linia = we.readLine().trim();

            try {

                if (linia.startsWith("calc ")) {
                    linia = linia.substring(5);   //Wydziel string po komendzie calc 
                    if (linia.contains("(") && linia.contains(")")) {    //Jeżeli dodano deklaracje zmiennych
			zmienneString = linia.substring((linia.indexOf("(")+1), linia.lastIndexOf(")")); //wyodrębnij środek nawiasów
			linia = linia.substring(0, linia.indexOf("("));   //odetnij nawiasy z końca linii
			dodajZmienne(zmienneString, lista);
                    }

                    if(linia.length() > 0) {
			Wyrazenie wyrazenie = new Wyrazenie(linia, lista);
			System.out.println(wyrazenie.oblicz());
                    }
                }
                else {
                    if (linia.startsWith("clear")) {
                        if(linia.equals("clear")) {
                            lista = new Lista();
                        }
                        else {
                            linia = linia.substring(6);   //Wydziel string po komendzie clear 
                            if (linia.contains("(") && linia.contains(")")) {    //Jeżeli podano zmienne do usunięcia
				zmienneString = linia.substring((linia.indexOf("(")+1), linia.lastIndexOf(")")); //wyodrębnij środek nawiasów
				usunZmienne(zmienneString, lista);
                                System.out.println("Wyczyszczono: " + zmienneString);
                            }
                            else {
                                throw new ONP_BledneWyrazenie("Jeśli chcesz usunąć konkretne zmienne, zapisz je w nawiasach.");
                            }
                        }
                    } 
                    else {
                        if (linia.startsWith("exit")) {
                            break;
                        }
                        else {
                            throw new ONP_BledneWyrazenie("Upewnij się, że wyrazenie jest poprawne.");
                        }
                    }
                }
            }
            catch(WyjatekONP e) {
                System.out.println(e);
            }
        } while (!linia.equals("exit"));
    }

    /**
     * Dodaj zmienne do listy zmiennych
     * @param s zmienne
     * @param lista obecna lista zmiennych
     * @throws ONP_PustaDeklaracjaZmiennych 
     */
    static void dodajZmienne(String s, Lista lista) throws ONP_PustaDeklaracjaZmiennych, ONP_NiedozwolonaZmienna {
        Pattern pat;
	Matcher mat;
	String deklaracja[];
        String[] niedozwolone_zmienne = {"Abs","Acot","Atan","Ceil","Ceil","Cos","+","-","*","\\","E","Exp","Floor","Frac","Ln","Log","Max","Min","Pi","Pow","Sgn","Sin"};

	pat = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*\\s*=\\s*-*[0-9]+\\.?[0-9]*");
	mat = pat.matcher(s);

	if (!mat.find()) {
            throw new ONP_PustaDeklaracjaZmiennych("Deklaracja jest pusta lub nie znaleziono prawidłowych przypisań.");
        }
	mat.reset();

	while(mat.find()) {
            deklaracja = mat.group().split("=");   // Podział deklaracji na 0. nazwie zmiennej 1. wartość
            if (Arrays.asList(niedozwolone_zmienne).contains(deklaracja[0])) {
                throw new ONP_NiedozwolonaZmienna("Zmienna " + deklaracja[0] + " jest niedozwolona!");
            }
            lista.przypisz(deklaracja[0].trim(), Double.parseDouble(deklaracja[1].trim()));
	}
    }

    /**
     * Usuń podane zmienne z listy zmiennych
     * @param s nazwy zmiennych
     * @param lista lista zmiennych
     * @throws ONP_NieznanySymbol 
     */
    static void usunZmienne(String s, Lista lista) throws ONP_NieznanySymbol {
	Pattern pat;
	Matcher mat;
				
	pat = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*");
	mat = pat.matcher(s);

	while(mat.find()) {
            lista.usun(mat.group());
	}
    }

}
