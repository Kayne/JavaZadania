package narzedzia;

/**
 * Nowe wyjątki
 * @author kayne
 */
public class WyjatekKonwersji extends Exception {
  
    /**
     * Treść wyjątku
     */
    protected String kumunikat;
    
    /**
     * Konstruktor wyjątku
     * @param s treść komunikatur
     */
    public WyjatekKonwersji(String s) {
        kumunikat = s;    
    }
  
    /**
     * Zwraca wyjątek w formie stringa
     * @return treść wyjątku
     */
    public String toString() {
        return "Wyjatek Konwersji: " + kumunikat;
    }
}
