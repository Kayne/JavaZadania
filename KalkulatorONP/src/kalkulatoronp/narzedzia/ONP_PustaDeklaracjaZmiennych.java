package kalkulatoronp.narzedzia;

/**
 * Wyjątek pustej deklaracji zmiennych
 * @author kayne
 */
public class ONP_PustaDeklaracjaZmiennych extends WyjatekONP {

    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_PustaDeklaracjaZmiennych (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_PustaDeklaracjaZmiennych " + super.kumunikat;
    }
}
