package kalkulatoronp.narzedzia;

/**
 * Interfejs zapewniający obliczalność
 * @author kayne
 */
public interface Obliczalny {
	
    /**
     * Funkcja obiczająca wartość
     * @return zwraca wartość
     * @throws WyjatekONP
     */
    double obliczWartosc () throws WyjatekONP;
}
