public class TrojkatPascala 
{
  private final static int MAX = 68; // 20 ??? nie, bo dla 68 wali się niebo
  private static long[][] trojkat = new long[MAX][];

  static {
    // inicjalicacja tablicy trojkat

    /* pierwszy wiersz */
    trojkat[0] = new long[3];
    trojkat[0][1] = 1;

    /* zapełniamy trójkąt rekurencyjnie */
    for (int i = 1; i <= MAX-1; i++) 
    {
      trojkat[i] = new long[i + 3];
      for (int j = 1; j < trojkat[i].length - 1; j++)
      {
        trojkat[i][j] = trojkat[i-1][j-1] + trojkat[i-1][j];
      }
    }
  }

  public static long czytaj (int n, int k) throws IllegalArgumentException 
  {
    return trojkat[n][k];
  }


}