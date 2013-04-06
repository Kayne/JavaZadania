package kalkulatoronp.narzedzia;

/**
 * Implementacja liczby
 * @author kayne
 */
public class Liczba extends Operand {

    private final double wartosc;
    
    
    /**
     * Konstruktor ustalający wartość liczby
     * @param wartosc wartość liczby
     */
    public Liczba(double wartosc) {
        this.wartosc = wartosc;
    }
	
    /**
     * Zwraca wartość liczby
     * @return wartość liczby
     */
    @Override
    public double obliczWartosc() {
	return wartosc;
    }
}
