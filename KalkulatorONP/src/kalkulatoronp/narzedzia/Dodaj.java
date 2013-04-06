package kalkulatoronp.narzedzia;

/**
 * Funkcja zwracająca wartość dodawania
 * @author kayne
 */
public class Dodaj extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[2];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość dodawania
     * @return wartość dodawnia
     */
    @Override
    public double obliczWartosc() {
        return argumenty[1] + argumenty[0];
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
