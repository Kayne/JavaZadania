package kalkulatoronp.narzedzia;


/**
 * Zwraca wartość funkcji logarytmicznej
 * @author kayne
 */
public class Log extends Funkcja implements Funkcyjny {

	
    private double argumenty[] = new double[2];
    private int dodane = 0;
	
	
    /**
     * Zwraca wartość logarytmu
     * @return wartość logarytmu
     * @throws ONP_NiedozwolonyArgumentFunkcji
     */
    @Override
    public double obliczWartosc() throws ONP_NiedozwolonyArgumentFunkcji {
        if (argumenty[1]<=0 || argumenty[0]<=0 || argumenty[0]==1 || argumenty[1]==1) {
            throw new ONP_NiedozwolonyArgumentFunkcji(": w funkcji Log.");
        }
        return Math.log(argumenty[0]) / Math.log(argumenty[1]);	
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