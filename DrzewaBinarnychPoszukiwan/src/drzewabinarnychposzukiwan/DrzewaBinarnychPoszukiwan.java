/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewabinarnychposzukiwan;
import drzewabinarnychposzukiwan.narzedzia.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Program testujący implementację Drzewa Binarnych Poszukiwań.
 * @author kayne
 */
public class DrzewaBinarnychPoszukiwan {

    /**
     * @param args the command line arguments
     * @throws IOException
     * @throws CloneNotSupportedException  
     */
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        // TODO code application logic here
        
        Map<String, DrzewoBST> drzewa = new HashMap<String, DrzewoBST>();
        
        /*
         * Tworzymy drzewka
         */
        for (String s : args) {
            drzewa.put(s, new DrzewoBST());
        }
        
        /*
         * Główna część programu
         */
        
        while (true)
        {
            try 
            {
                System.out.print("komenda: ");
                BufferedReader we = new BufferedReader(new InputStreamReader(System.in));
                String[] tab = we.readLine().trim().split("\\s+");
            
                if (tab[0].equals("insert"))
                {
                    if (tab[1] != null && tab[2] != null && tab[3] != null)
                    {
                        int liczba = new Integer(tab[3]);
                        DrzewoBST drzewko = drzewa.get(tab[1]);
                        drzewko.wstaw(tab[2], new Double(tab[3]));
                    }
                    else
                    {
                        print_error();
                    }
                }
                else if (tab[0].equals("delete"))
                {
                    if (tab[1] != null && tab[2] != null)
                    {
                        DrzewoBST drzewko = drzewa.get(tab[1]);
                        drzewko.usuń(tab[2]);
                    }
                    else
                    {
                        print_error();
                    }
                }
                else if (tab[0].equals("search"))
                {
                    if (tab[1] != null && tab[2] != null)
                    {
                        DrzewoBST drzewko = drzewa.get(tab[1]);
                        if (drzewko.szukaj(tab[2]))
                        {
                            System.out.println("yes");                            
                        }
                        else
                        {
                            System.out.println("no");
                        }
                    }
                    else
                    {
                        print_error();
                    }
                }
                else if (tab[0].equals("clone"))
                {
                    if (tab[1] != null && tab[2] != null)
                    {
                        DrzewoBST drzewko = drzewa.get(tab[1]);
                        drzewa.put(tab[2], drzewko.clone());
                    }
                    else
                    {
                        print_error();
                    }
                }
                else if (tab[0].equals("print"))
                {
                    if (tab[1] != null)
                    {
                        DrzewoBST drzewko = drzewa.get(tab[1]);
                        drzewko.printTree();
                        System.out.print("\n");
                    }
                    else
                    {
                        print_error();
                    }
                }
                else if (tab[0].equals("count"))
                {
                    if (tab[1] != null)
                    {
                        DrzewoBST drzewko = drzewa.get(tab[1]);
                        System.out.println(drzewko.ile());
                    }
                    else
                    {
                        print_error();
                    }
                }
                else if (tab[0].equals("exit"))
                {
                    break;
                }
                else
                {
                    print_error();
                }
            }
            catch (ArrayIndexOutOfBoundsException ex)
            {
                print_error();
            }
            catch (NumberFormatException ex)
            {
                print_error();
            }
            catch (NullPointerException ex)
            {
                print_error();
            }
        }
        
    }
    
    private static void print_error()
    {
        System.out.println("?!? nie znane polecenie !?!");
    }
}
