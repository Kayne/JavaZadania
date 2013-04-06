package kalkulatoronp.narzedzia;



/**
 * Zwraca wartość funkcji signum
 * @author kayne
 */
public class Sgn extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[1];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość signum
     * @return wartość signum
     */
    @Override
    public double obliczWartosc() {
        return Math.signum(argumenty[0]);
    }

    /**
     * Ilość argumentów
     * @return ilość argumentów
     */
    @Override
    public int arnosc() {
        return 1;
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