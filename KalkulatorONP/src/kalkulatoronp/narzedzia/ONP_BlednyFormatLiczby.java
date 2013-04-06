package kalkulatoronp.narzedzia;

/**
 * Wyjątek błednego formatu liczby
 * @author kayne
 */
public class ONP_BlednyFormatLiczby extends WyjatekONP {

	
    /**
     * Konstruktro wyjątku
     * @param s treść wyjątku
     */
    public ONP_BlednyFormatLiczby (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_BlednyFormatLiczby " + super.kumunikat + "Pow�d: " + this.getCause();
    }
}
