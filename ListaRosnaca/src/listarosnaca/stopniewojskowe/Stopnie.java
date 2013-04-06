/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listarosnaca.stopniewojskowe;

/**
 *
 * @author kayne
 */
public class Stopnie implements Comparable<Stopnie> {
    String name;
    int priority;
    
    public Stopnie ()
    {
        name = "";
        priority = -1;
    }

    /**
     * Porównuje dwa stopnie na podstawie ich stopni.
     * @param o Inny stopień do porównania (typu Stopnie)
     * @return -1 mniejszy, 0 równy, 1 większy
     */
    @Override
    public int compareTo(Stopnie o) {
        if (priority < o.priority)
        {
            return -1;
        }
        
        if (priority == o.priority)
        {
            return 0;
        }
        
        return 1;
    }
    
    @Override
    public String toString()
    {
        return "Cześć, jestem " + name + " i mam priorytet: " + priority;
    }
    
    
}
