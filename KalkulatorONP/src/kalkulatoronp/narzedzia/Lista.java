package kalkulatoronp.narzedzia;


/**
 *
 * @author kayne
 */
public class Lista {
    
    /**
     * Korzeń węzła
     */
    private Wezel top = null;
	
	
    class Wezel {
        
        /**
         * Wartość węzła
         */
        private double wartosc;
        /**
         * Nazwa węzła
         */
        private String nazwa;
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
         * @param nazwa nazwa węzła
         * @param wartosc wartość węzła
         */
        public Wezel(Wezel poprzednik, String nazwa, double wartosc) {
            this.poprzednik = poprzednik;
            this.wartosc = wartosc;
            this.nazwa = nazwa;
            this.nastepnik = null;
        }
		
        /**
         * Czyta wartość węzła
         * @param wezel który węzeł
         * @param nazwa nazwa węzła
         * @return wartość węzła
         * @throws ONP_NieznanySymbol 
         */
	private double czytaj (Wezel wezel, String nazwa) throws ONP_NieznanySymbol {
            if (wezel.nazwa.equals(nazwa)) {
                return wezel.wartosc;
            }
            else {
                if(wezel.nastepnik == null) {
                    throw new ONP_NieznanySymbol(nazwa);
                }
                else {
                    return czytaj(wezel.nastepnik, nazwa);
                }
            }
        }
        
        /**
         * Przypisuje wartość do węzła lub tworzy nowy
         * @param wezel obecny węzeł
         * @param nazwa nazwa węzła jaka ma być
         * @param wartosc wartość jaką mamy wpisać
         */
        private void przypisz (Wezel wezel, String nazwa, double wartosc) {
            if (wezel.nazwa.equals(nazwa)) {
                wezel.wartosc = wartosc;
            }
            else {
                if (wezel.nastepnik == null) {
                    wezel.nastepnik = new Wezel(wezel, nazwa, wartosc);
                }
                else {
                    przypisz (wezel.nastepnik, nazwa, wartosc);
                }
            }
        }
        
        /**
         * Usuwa węzeł
         * @param wezel obecny węzeł
         * @param nazwa nazwa usuwanego węzła
         * @throws ONP_NieznanySymbol 
         */
	private void usun (Wezel wezel, String nazwa) throws ONP_NieznanySymbol {
            if (wezel.nazwa.equals(nazwa)) { 
                if(wezel.poprzednik == null) { //wezel jest topem
                    top = wezel.nastepnik == null ? null : wezel.nastepnik; //Jeśli istnieje następnik, to staje się topem
                    if (top != null) {
                        top.poprzednik = null;
                    }
                }
                else {
                    wezel.poprzednik.nastepnik = wezel.nastepnik == null ? null : wezel.nastepnik;
                }
            }
            else {
                if(wezel.nastepnik != null) {
                    usun(wezel.nastepnik, nazwa);
                }
                else {
                    throw new ONP_NieznanySymbol(nazwa);
                }
            }			
        }
    }
	
    /**
     * Czy lista jest pusta
     * @return boolean czy lista jest pusta (True dla tak)
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
     * 
     * @param nazwa
     * @return wartość zmiennej
     * @throws ONP_NieznanySymbol
     */
    public double czytaj (String nazwa) throws ONP_NieznanySymbol {
        if (top == null) {
            throw new ONP_NieznanySymbol(nazwa);
        }
	else {
            return top.czytaj(top, nazwa);
        }
    }
	
    /**
     * Przypisuje liczbę do węzła z podaną nazwą
     * @param nazwa nazwa węzła
     * @param liczba liczba do wpisania
     */
    public void przypisz (String nazwa, double liczba) {
        if(top == null) {
            top = new Wezel(null, nazwa, liczba);
        }
        else {
            top.przypisz(top, nazwa, liczba);
        }
    }
	
    /**
     * Usuwa węzeł
     * @param nazwa nazwa węzła
     * @throws ONP_NieznanySymbol
     */
    public void usun (String nazwa) throws ONP_NieznanySymbol {
        if (top == null) {
            throw new ONP_NieznanySymbol(nazwa);
        }
        top.usun(top, nazwa);
    }
}
