public class untitled {

    public static void main(String[] args) throws Exception
    {
      int w = 0;
      for (int i = 0; i < 5; i++)
      {
        System.out.format("\n\nPrzebieg %d\n", w);
        System.out.println("--------------------");
        w++;
        kwadrat(3+2*i);
      }
      for (int i = 0; i < 5; i++)
      {
        System.out.format("\n\nPrzebieg %d\n", w);
        System.out.println("--------------------");
        w++;
        kwadrat2(3+i);
      }
      System.out.println("\n");
    }

    public static void kwadrat(int n)
    {
      for (int i = 0; i < n; i++)
      {
        System.out.print("\n");
        for (int j = 0; j < n; j++)
        {
          System.out.print("* ");
        }
      }
    }

    public static void kwadrat2(int n)
    {
      for (int i = 0; i < n; i++)
      {
        System.out.print("\n");
        for (int j = 0; j < n; j++)
        {
          System.out.print("#");
        }
      }
    }

}