package kalkulatoronp.narzedzia;

/**
 * Klasa reprezentująca wyrażenie
 * @author kayne
 */
public class Wyrazenie {

    private Kolejka kolejka;
    private Stos stos = new Stos();
    private String onp;
	
    private Lista lista;
	
    /**
     * Konstruktor wyrażenia
     * @param onp wartość wyrażenia w ONP
     * @param lista lista zmiennych
     */
    public Wyrazenie (String onp, Lista lista) {
        this.onp = onp;
	this.lista = lista;
    }
    
    /**
     * Tworzy kolejkę
     * @throws WyjatekONP 
     */
    private void utworzKolejke () throws WyjatekONP {
        kolejka = new Kolejka();
		

        String tab[] = onp.split("\\s+");
        for (String s : tab) {

            assert s.length() > 0;

            if (Character.isDigit(s.charAt(0)) || ( (s.length() > 1) && ( Character.isDigit(s.charAt(1)) && (s.charAt(0) == '-') ) )) { //jeśeli s zaczyna się od cyfry
                try{
                    kolejka.dodaj(new Liczba(Double.parseDouble(s)));  
		} catch (Exception e) {
                    ONP_BlednyFormatLiczby bl = new ONP_BlednyFormatLiczby("Liczba zawiera niedozwolone znaki.");
                    bl.initCause(e);
                    throw bl;
		}
            }
            else {
                if (s.equals("+")) {
                    kolejka.dodaj(new Dodaj());
                }
                else if (s.equals("*")) {
                    kolejka.dodaj(new Mnoz());
                }
                else if (s.equals("-")) {
                    kolejka.dodaj(new Odejmij());
                }
                else if (s.equals("/")) {
                    kolejka.dodaj(new Dziel());
                }
                else if (s.equals("Abs")) {
                    kolejka.dodaj(new Abs());
                }
                else if (s.equals("Sgn")) {
                    kolejka.dodaj(new Sgn());
                }
                else if (s.equals("Floor")) {
                    kolejka.dodaj(new Floor());
                }
                else if (s.equals("Ceil")) {
                    kolejka.dodaj(new Ceil());
                }
                else if (s.equals("Frac")) {
                    kolejka.dodaj(new Frac());
                }
                else if (s.equals("Min")) {
                    kolejka.dodaj(new Min());
                }
                else if (s.equals("Max")) {
                    kolejka.dodaj(new Max());
                }
                else if (s.equals("Sin")) {
                    kolejka.dodaj(new Sin());
                }
                else if (s.equals("Cos")) {
                    kolejka.dodaj(new Cos());
                }
                else if (s.equals("Atan")) {
                    kolejka.dodaj(new Atan());
                }
                else if (s.equals("Acot")) {
                    kolejka.dodaj(new Acot());
                }
                else if (s.equals("Ln")) {
                    kolejka.dodaj(new Ln());
                }
                else if (s.equals("Exp")) {
                    kolejka.dodaj(new Exp());
                }
                else if (s.equals("Log")) {
                    kolejka.dodaj(new Log());
                }
                else if (s.equals("Pow")) {
                    kolejka.dodaj(new Pow());
                }
                else if (s.equals("E")) {
                    kolejka.dodaj(new E());
                }
                else if (s.equals("Pi")) {
                    kolejka.dodaj(new Pi());
                }
                else {
                    lista.czytaj(s);
                    kolejka.dodaj(new Zmienna(s, lista));
                }
            }
        }
    }

    /**
     * Wykonaj działanie
     * @param fun funkcja do wykonania
     * @throws WyjatekONP 
     */
    private void wykonaj (Funkcja fun) throws WyjatekONP {
        try{
            while (fun.brakujaceArgumenty() > 0) {
                fun.dodajArgument(stos.zdejmij());
            }
            stos.poloz(fun.obliczWartosc());
        } 
        catch(ONP_PustyStos e) {
            ONP_ZaMaloArgumentow zam = new ONP_ZaMaloArgumentow("Niewystarczająca ilość argumentów dla funkcji.");
            zam.initCause(new ONP_PustyStos(" "));
            throw zam;
        }
    }

    /**
    * Oblicza wyrażenie
    * @return wartość wyrażenia
    * @throws WyjatekONP
    */
    public double oblicz () throws WyjatekONP {

        utworzKolejke();

        while (!kolejka.pusta()) {

            Symbol tmp = kolejka.pobierz();

            if (tmp.getClass().getSimpleName().equals("Liczba")) {
                    stos.poloz(tmp.obliczWartosc());
            }

            if (tmp.getClass().getSimpleName().equals("Zmienna")) {
                    stos.poloz(tmp.obliczWartosc());
            }

            if (tmp.getClass().getSimpleName().equals("Dodaj")) {
                    Dodaj f = new Dodaj();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Mnoz")) {
                    Funkcja f = new Mnoz();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Odejmij")) {
                    Funkcja f = new Odejmij();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Dziel")) {
                    Funkcja f = new Dziel();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Abs")) {
                    Funkcja f = new Abs();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Sgn")) {
                    Funkcja f = new Sgn();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Floor")) {
                    Funkcja f = new Floor();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Ceil")) {
                    Funkcja f = new Ceil();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Frac")) {
                    Funkcja f = new Frac();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Min")) {
                    Funkcja f = new Min();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Max")) {
                    Funkcja f = new Max();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Sin")) {
                    Funkcja f = new Sin();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Cos")) {
                    Funkcja f = new Cos();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Atan")) {
                    Funkcja f = new Atan();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Acot")) {
                    Funkcja f = new Acot();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Ln")) {
                    Funkcja f = new Ln();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Exp")) {
                    Funkcja f = new Exp();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Log")) {
                    Funkcja f = new Log();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Pow")) {
                    Funkcja f = new Pow();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("E")) {
                    Funkcja f = new E();
                    wykonaj(f);
            }

            if (tmp.getClass().getSimpleName().equals("Pi")) {
                    Funkcja f = new Pi();
                    wykonaj(f);
            }
        }

        assert !stos.pusty() : "Stos jest pusty po wykonaniu ubliczeń!";			
        return stos.zdejmij();
    }

}
