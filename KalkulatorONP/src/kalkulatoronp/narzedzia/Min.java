package kalkulatoronp.narzedzia;

/**
 * Zwraca wartość najmniejszą z podanych
 * @author kayne
 */
public class Min extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[2];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość najmniejszą
     * @return wartość najmniejsza
     */
    @Override
    public double obliczWartosc() {
        return (argumenty[0] >= argumenty[1] ? argumenty[1] : argumenty[0]);
    }

    /**
     * Ilość argumentów
     * @return ilość argumentów
     */
    @Override
    public int arnosc() {
        return 2;
    }

    /**
     * Ile jeszcze argumentów potrzeba
     * @return ilość potrzebnych argumentów
     */
    @Override
    public int brakujaceArgumenty() {
        return arnosc()-dodane;
    }

    /**
     * Dodaje argument
     * @param argument
     */
    @Override
    public void dodajArgument(double argument) {
	argumenty[dodane++] = argument;
    }
}
