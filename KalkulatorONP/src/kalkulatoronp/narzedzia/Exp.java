package kalkulatoronp.narzedzia;



/**
 * Zwraca liczbę E podniesioną do podanej potęgi
 * @author kayne
 */
public class Exp extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[1];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość liczby E podniesionej do podanej potęgi
     * @return wartość potęgi liczby E
     */
    @Override
    public double obliczWartosc() {
        return Math.exp(argumenty[0]);
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