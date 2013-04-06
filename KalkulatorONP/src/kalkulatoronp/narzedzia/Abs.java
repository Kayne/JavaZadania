package kalkulatoronp.narzedzia;


/**
 * Zwraca wartość bezwzględną
 * @author kayne
 */
public class Abs extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[1];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość funkcji (wartość bezwzględną)
     * @return wartość bezwzględną wartości
     */
    @Override
    public double obliczWartosc() {
        return Math.abs(argumenty[0]);
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