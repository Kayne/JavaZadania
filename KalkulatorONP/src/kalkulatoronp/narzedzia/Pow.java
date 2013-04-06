package kalkulatoronp.narzedzia;


/**
 * Funkcja zwracająca wartość potęgowania
 * @author kayne
 */
public class Pow extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[2];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość potęgi
     * @return wartość potęgi
     */
    @Override
    public double obliczWartosc() {
        return Math.pow(argumenty[1], argumenty[0]);
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
