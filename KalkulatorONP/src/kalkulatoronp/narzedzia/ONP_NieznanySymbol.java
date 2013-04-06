package kalkulatoronp.narzedzia;

/**
 * Wyjątek nienznanego symbolu
 * @author kayne
 */
public class ONP_NieznanySymbol extends WyjatekONP {

    /**
     * Konstruktor wyjątku
     * @param s treść wyjątku
     */
    public ONP_NieznanySymbol (String s) {
        super(s);
    }
	
    /**
     * Zwraca wyjątek w postaci stringa
     * @return wyjątek
     */
    public String toString() {
        return "ONP_NieznanySymbol: " + super.kumunikat;
    }
}
