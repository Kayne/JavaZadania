package kalkulatoronp.narzedzia;

/**
 * Interfejs dla klas funkcyjnych
 * @author kayne
 */
public interface Funkcyjny extends Obliczalny {
	
    /**
     * Ilość argumentów
     * @return ilość argumentów
     */
    int arnosc ();
    /**
     * Ile jeszcze potrzebnych argumentów
     * @return ilość potrzebnych argumentów
     */
    int brakujaceArgumenty ();
    /**
     * Dodaj argument
     * @param argument dodawany argument
     * @throws WyjatekONP
     */
    void dodajArgument (double argument)  throws WyjatekONP;
}
