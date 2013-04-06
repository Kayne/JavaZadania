package kalkulatoronp.narzedzia;



/**
 * Funkcja zwracająca wartość liczby PI
 * @author kayne
 */
public class Pi extends Funkcja implements Funkcyjny {

	
		
    /**
     * Zwraca wartość liczby PI
     * @return wartość liczby PI
     */
    @Override
    public double obliczWartosc() {
	return Math.PI;
    }

    /**
     * Ilość argumentów
     * @return ilość argumentów
     */
    @Override
    public int arnosc() {
        return 0;
    }

    /**
     * Ile jeszcze argumentów potrzeba
     * @return ilość potrzebnych argumentów
     */
    @Override
    public int brakujaceArgumenty() {
        return 0;
    }

    /**
     * Dodaje argument
     * @param argument
     */
    @Override
    public void dodajArgument(double argument) {
    }
}