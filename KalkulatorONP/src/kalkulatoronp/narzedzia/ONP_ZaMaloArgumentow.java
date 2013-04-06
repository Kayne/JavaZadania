package kalkulatoronp.narzedzia;

/**
 * Wyjątek za mało argumentów
 * @author kayne
 */
public class ONP_ZaMaloArgumentow extends WyjatekONP {

    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_ZaMaloArgumentow (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_BledneWyrazenie: " + super.kumunikat + " Powód: " + this.getCause();
    }
}
