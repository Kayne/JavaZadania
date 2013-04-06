package kalkulatoronp.narzedzia;

/**
 * Wyjątek niedozwolonego argumentu funkcji
 * @author kayne
 */
public class ONP_NiedozwolonyArgumentFunkcji extends WyjatekONP {

    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_NiedozwolonyArgumentFunkcji (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_NiedozwolonyArgumentFunkcji " + super.kumunikat;
    }
}
