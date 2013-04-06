package kalkulatoronp.narzedzia;

/**
 * Nowe wyjątki
 * @author kayne
 */
public class WyjatekONP extends Exception {
	
    /**
     * Treść wyjątku
     */
    protected String kumunikat;
    
    /**
     * Konstruktor wyjątku
     * @param s treść komunikatur
     */
    public WyjatekONP(String s) {
        kumunikat = s;		
    }
	
    /**
     * Zwraca wyjątek w formie stringa
     * @return treść wyjątku
     */
    public String toString() {
        return "WyjatekONP: " + kumunikat;
    }
}
