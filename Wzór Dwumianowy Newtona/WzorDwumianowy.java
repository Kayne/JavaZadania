import static java.lang.System.out;

public class WzorDwumianowy
{

  public static boolean one_char (String str)
  {
    int wystapienia = 0;
    for (int i = 0; i <= str.length(); i++)
    {
      if (str.startsWith("-",i) || str.startsWith("+",i))
      {
        wystapienia += 1;
      }
      if (wystapienia > 1)
      {
        break;
      }
    }
    if (wystapienia > 1)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  private static void print_error()
  {
    out.println("Błędne argumenty programu!");
  }

  public static void main (String[] args)
  {
    try
    {
      /* Sprawdzamy czy nie ma więcej znaków operacji w zmiennych niż 1 */
      if (!one_char(args[0]))
      {
        throw new IllegalArgumentException();
      }

      /* Sprawdzamy jaki mamy znak */
      boolean plus = true;

      int p = args[0].indexOf('+');
      if (p == -1)
      {
        plus = false;
        p = args[0].indexOf('-');
      }

      /* Przypisujemy resztę zmiennych */

      String znak = (plus == true) ? "+" : "-";


      String first = args[0].substring(0,p);
      String second = args[0].substring(p+1);
      

      int n = new Integer(args[1]);
      long w = 0;
      int a = n-1;
      int b = 1;
      boolean firstone = true;
      boolean bylo = false;

      /* Sprawdzamy czy nie mamy wywołanego programu z ujemną potęgą */
      if (n < 0)
      {
        out.println("Wywołuj program dla liczb naturalnych z 0 włącznie");
      }
      else
      {
        out.print("("+first+znak+second+")^"+n+" = ");
      }

      /* Sprawdzamy dwa pierwsze wyniki, bo różnią się od reszty */
      if (n == 0)
      {
        out.print("1");
      }
      else if (n == 1)
      {
        out.print(first + " " + znak + " " + second);
      }

      /* Budujemy równanie */
      for (int i = 2; i <= n+n/2; i++)
      {
        w = TrojkatPascala.czytaj(n,i);
        if (w == 0)
        {
          break;
        }

        /* Ustawiamy znak */
        if (plus == false)
        {
          if (bylo == false)
          {
            znak = "+";
            bylo = true;
          }
          else
          {
            znak = "-";
            bylo = false;
          }
        }

        /* Sprawdzamy który element jest [pierwszy równania czy inny] */
        if (firstone == true)
        {
          firstone = false;
          out.print(first+"^"+n);
        }
        if (w != 1) // „normalne” elementy równania
        {
          if (a == 1)
          {
            out.print(" "+znak+" "+w+"*"+first);
          }
          else
          {
            out.print(" "+znak+" "+w+"*"+first+"^"+a);
          }
          a -= 1;

          if (b == 1)
          {
            out.print("*"+second);
          }
          else
          {
            out.print("*"+second+"^"+b);
          }
          b += 1;
        }
        else // otatni element równania
        {
          out.print(" "+znak+" "+second+"^"+n);
        }
      }
      out.println("");
    }
    catch (StringIndexOutOfBoundsException ex)
    {
      print_error();
    }
    catch (NumberFormatException ex)
    {
      print_error();
    }
    catch (ArrayIndexOutOfBoundsException ex)
    {
      print_error();
    }
    catch (IllegalArgumentException ex)
    {
      print_error();
    }
  }
}