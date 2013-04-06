package kalkulatoronp.narzedzia;


/**
 * Implementacja kolejki
 * @author kayne
 */
public class Kolejka {
    
    /**
     * Korzeń kolejki
     */
    private Wezel top = null;
	
	
    class Wezel {
        
        /**
         * Przechowywany symbol
         */
        private final Symbol symbol;
        /**
         * Poprzedni węzeł
         */
	private Wezel poprzednik;
        /**
         * Następny węzeł
         */
	private Wezel nastepnik;
        
        /**
         * Konstruktor węzła
         * @param poprzednik poprzedni węzeł
         * @param symbol przechowywany symbol
         */
	public Wezel(Wezel poprzednik, Symbol symbol) {
            this.poprzednik = poprzednik;
            this.symbol = symbol;
            this.nastepnik = null;
	}
        
        /**
         * Pobierz symbol z kolejki
         * @param wezel obecny węzeł
         * @return symbol
         */
        private Symbol pobierz (Wezel wezel) {
            Symbol s = wezel.symbol;
            top = wezel.nastepnik;
            top.poprzednik = null;
            return s;
        }
        
        /**
         * Dodaj węzeł z symbolem
         * @param symbol dodawany symbol
         * @param wezel obecny węzeł
         */
        private void dodaj (Symbol symbol, Wezel wezel) {
            if(wezel.nastepnik == null) {
                wezel.nastepnik = new Wezel(wezel, symbol);
            }
            else {
                dodaj(symbol, wezel.nastepnik);
            }
        }

    }
	
    /**
     * Sprawdza czy kolejka jest pusta
     * @return boolean czy kolejka pusta (True dla tak)
     */
    public boolean pusta () {
        if (top == null) {
            return true;
        }
	else {
            return false;
        }
    }
	
    /**
     * Pobiera element z kolejki
     * @return symbol z kolejki
     */
    public Symbol pobierz () {
	assert top != null;
	if (top.nastepnik == null) {
            Symbol s = top.symbol;
            top = null;
            return s;
        }
	else {
            return top.pobierz(top);
        }
    }
	
    /**
     * Dodaj symbol do kolejki
     * @param symbol dodawany symbol
     */
    public void dodaj (Symbol symbol) {
        if(top == null) {
            top = new Wezel(null, symbol);
        }
	else {
            top.dodaj(symbol, top);
        }
    }
}