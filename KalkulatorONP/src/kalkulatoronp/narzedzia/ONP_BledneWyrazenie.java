package kalkulatoronp.narzedzia;

/**
 * Wyjątek błędnego wyrażenia
 * @author kayne
 */
public class ONP_BledneWyrazenie extends WyjatekONP {
	
    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_BledneWyrazenie (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_BledneWyrazenie: " + super.kumunikat;
    }
}
