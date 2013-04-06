package kalkulatoronp.narzedzia;

/**
 * Funkcja zwracająca wartość dzielenia
 * @author kayne
 */
public class Dziel extends Funkcja implements Funkcyjny  {


    private double argumenty[] = new double[2];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość dzielenia
     * @return wartość dzielenia
     * @throws ONP_DzieleniePrzez0 wyjątek przydzieleniu przez zero
     */
    @Override
    public double obliczWartosc() throws ONP_DzieleniePrzez0 {
        if (argumenty[1]==0)
            throw new ONP_DzieleniePrzez0(": w funkcji Dziel.");
	return argumenty[1] / argumenty[0];
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
