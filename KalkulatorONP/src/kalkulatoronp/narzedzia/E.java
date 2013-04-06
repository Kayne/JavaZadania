package kalkulatoronp.narzedzia;



/**
 * Zwraca wartość liczby E
 * @author kayne
 */
public class E extends Funkcja implements Funkcyjny {

    /**
     * Zwraca wartość liczby E
     * @return liczba E
     */
    @Override
    public double obliczWartosc() {
        return Math.E;
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