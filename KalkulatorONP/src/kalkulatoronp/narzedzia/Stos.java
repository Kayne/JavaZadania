package kalkulatoronp.narzedzia;

/**
 * Implementacja stosu
 * @author kayne
 */
public class Stos {
	
    private Wezel top = null;
	
	
    class Wezel {
        
        /**
         * Wartość węzła
         */
        private final double wartosc;
        /**
         * Poprzedni węzeł
         */
        private Wezel poprzednik;
        /**
         * Następny węzeł
         */
	private Wezel nastepnik;
		
        /**
         * Konsturktor węzła
         * @param poprzednik poprzedni węzeł 
         * @param wartosc wartość węzła
         */
	public Wezel(Wezel poprzednik, double wartosc) {
            this.poprzednik = poprzednik;
            this.wartosc = wartosc;
            this.nastepnik = null;
        }
        
        /**
         * Zdejmuje węzeł ze stosu i zwraca jego wartość
         * @param wezel obecny węzeł
         * @return wartość stosu
         */
        private double zdejmij (Wezel wezel) {
            if (wezel.nastepnik != null) {
                return zdejmij (wezel.nastepnik);
            }
            else {
                wezel.poprzednik.nastepnik = null;
                return wezel.wartosc;
            }
        }
        
        /**
         * Dodaje węzeł na stos
         * @param liczba dodawna na stos liczba
         * @param wezel obecny węzeł
         */
        private void poloz (double liczba, Wezel wezel) {
            if(wezel.nastepnik == null) {
                wezel.nastepnik = new Wezel(wezel, liczba);
            }
            else {
                poloz(liczba, wezel.nastepnik);
            }
        }
    }
	
    /**
     * Czy stos jest pusty
     * @return boolean czy stos jest pusty (True dla tak)
     */
    public boolean pusty () {
        if (top == null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Zdejmuje węzeł ze stosu
     * @return wartość zdjętego węzła
     * @throws WyjatekONP
     */
    public double zdejmij() throws WyjatekONP {
        if (top == null) {
            throw new ONP_PustyStos("Próba zdjęcia elementu z pustego stosu");
        }
        if (top.nastepnik == null) {
            double w = top.wartosc;
            top = null;
            return w;
        }
        else {
            return top.zdejmij(top);
        }
    }
	
    /**
     * Dodaj liczbę na stos
     * @param liczba dodawana liczba
     */
    public void poloz (double liczba) {
        if(top == null) {
            top = new Wezel(null, liczba);
        }
	else {
            top.poloz(liczba, top);
        }
    }
}
