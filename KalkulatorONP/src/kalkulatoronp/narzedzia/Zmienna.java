package kalkulatoronp.narzedzia;

/**
 * Implementacja zmiennej
 * @author kayne
 */
public class Zmienna extends Operand {
	
    private String nazwa;
    private double wartosc;
	
    /**
     * Konstruktor zmiennej
     * @param nazwa nazwa zmiennej
     * @param lista lista zmiennych
     * @throws ONP_NieznanySymbol
     */
    public Zmienna(String nazwa, Lista lista) throws ONP_NieznanySymbol {
        this.nazwa = nazwa;
        this.wartosc = lista.czytaj(nazwa);
    }
	
    /**
     * Zwraca wartość zmiennej
     * @return wartość zmiennej
     */
    @Override
    public double obliczWartosc() {
        return wartosc;
    }
}
