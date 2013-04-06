public class Fib
{
  public static void main (String[] args)
  {
    try 
    {
      int n = new Integer(args[0]);
      String a = new String(args[1]);
      String b = new String(args[2]);

      if (a.length() != 1 || b.length() != 1 )
      {
        throw new IllegalArgumentException();
      } 
      if (a.compareTo(b) == 0)
      {
        throw new IllegalArgumentException();
      }

      String[] wynik = new String[n+1];
      for (int w = 1; w <= n; w++)
      {
        wynik[w] = new StringBuffer(Fib(w, a, b)).reverse().toString();
      }

      System.out.println(wynik[n]);
    }
    catch (NumberFormatException ex)
    {
      System.out.println("błędne argumenty wywołania programu");
    }
    catch (IllegalArgumentException ex) 
    {
      System.out.println("błędne argumenty wywołania programu");
    }
    catch (ArrayIndexOutOfBoundsException ex)
    {
      System.out.println("błędne argumenty wywołania programu");
    }
  }


  public static String Fib(int n, String a, String b)
  {
    if (n == 1)
    {
      return a;
    } 
    else if (n == 2)
    {
      return b;
    }
    else
    {
      return (Fib(n-1, a, b) + Fib(n-2, a, b));
    }
  }
}