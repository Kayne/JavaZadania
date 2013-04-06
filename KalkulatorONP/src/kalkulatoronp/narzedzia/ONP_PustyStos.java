package kalkulatoronp.narzedzia;

/**
 * Wyjątek pustego stosu
 * @author kayne
 */
public class ONP_PustyStos extends WyjatekONP {

    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_PustyStos (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_PustyStos: " + super.kumunikat;
    }
}
