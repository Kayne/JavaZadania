package narzedzia;

/**
* Obsługa konwersji liczb
**/
public class RzymArab {

  /**
  * Cyfry rzymskie i ich odpowiedniki arabskie
  **/
  private static final int arabska[] = {1000, 500, 100, 50, 10, 5, 1};
  private static final char rzymska[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
  private static final int RZYMSKA_N = arabska.length;

  /**
  * Konwersja liczby rzymskiej na arabską
  * @param String liczba rzymska
  * @return int liczba arabska
  **/
  public int rzym2arab (String liczba) throws WyjatekKonwersji {
    int i = 0, j = 0, wynik = 0, długość = 0;
     
    długość = liczba.length();
     
    while ((j < długość) && (i < RZYMSKA_N))
    {
      if (liczba.charAt(j) == rzymska[i])
      {
        wynik += arabska[i];
        j++;
      }
      else if ((i % 2 == 0) && (i < RZYMSKA_N - 2) && (j < długość-1) && (liczba.charAt(j) == rzymska[i+2]) && (liczba.charAt(j+1) == rzymska[i])) {
        wynik += arabska[i] - arabska[i+2];
        j += 2;
        i++;
      }
      else if ((i % 2 == 1) && (i < RZYMSKA_N-1) && (j < długość-1) && (liczba.charAt(j) == rzymska[i+1]) && (liczba.charAt(j+1) == rzymska[i])) {
        wynik += arabska[i] - arabska[i+1];
        j += 2;
        i++;
      }
        else {
        i++;
      }
    }
      
    if (i == RZYMSKA_N) {
      throw new WyjatekKonwersji("Nie ma takiej liczby!");
    }

    return wynik;
  }

  /**
  * Konwersja arabskiej na rzymską
  * @param int liczba arabska
  * @return String liczba rzymska
  **/
  public String arab2rzym (int liczba) throws WyjatekKonwersji {
    int i = 0;
    String wynik = "";

    while ((liczba > 0) && (i < RZYMSKA_N))
    {
      if (liczba >= arabska[i]) {
        liczba -= arabska[i];
        wynik += rzymska[i];
      }
      else if ((i % 2 == 0) && (i < RZYMSKA_N - 2) && (liczba >= arabska[i] - arabska[i+2]) && (arabska[i+2] != arabska[i] - arabska[i+2])) {
        liczba -= arabska[i] - arabska[i+2];
        wynik += rzymska[i+2];
        wynik += rzymska[i];
        i++;
      }
      else if ((i % 2 == 1) && (i < RZYMSKA_N - 1) && (liczba >= arabska[i] - arabska[i+1]) && (arabska[i+1] != arabska[i] - arabska[i+1])) {
        liczba -= arabska[i] - arabska[i+1];
        wynik += rzymska[i+1];
        wynik += rzymska[i];
        i++;
      } 
      else {
        i++;
      }
    }

    return wynik;
  }
}