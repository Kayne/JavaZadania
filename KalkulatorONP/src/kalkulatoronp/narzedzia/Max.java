package kalkulatoronp.narzedzia;

/**
 * Zwraca większą z dwóch wartości
 * @author kayne
 */
public class Max extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[2];
    private int dodane = 0;
	
	
    /**
     * Zwraca wynik operacji porównania dwóch liczb (zwraca większą)
     * @return wynik operacji
     */
    @Override
    public double obliczWartosc() {
        return (argumenty[0] <= argumenty[1] ? argumenty[1] : argumenty[0]);	
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
