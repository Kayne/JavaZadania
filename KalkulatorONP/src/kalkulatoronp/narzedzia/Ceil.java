package kalkulatoronp.narzedzia;


/**
 * Funkcja zaokrąglająca w górę
 * @author kayne
 */
public class Ceil extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[1];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość zaokrąglenia w górę
     * @return zaokrąglenie w górę
     */
    @Override
	public double obliczWartosc() {
		return Math.ceil(argumenty[0]);
		
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