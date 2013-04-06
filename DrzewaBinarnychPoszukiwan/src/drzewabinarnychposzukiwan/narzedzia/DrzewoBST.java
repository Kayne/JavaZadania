/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewabinarnychposzukiwan.narzedzia;

/**
 * Klasa definiująca drzwo binarnych poszukiwań w oparciu o interfejs Slownik i Cloneable.
 * @author kayne
 */
public class DrzewoBST implements Slownik, Cloneable {

    /**
     * Prywatna klasa węzeł będące „sercem” drzewa, łączący ze sobą pary.
     * Każdy węzeł przechowuje w sobie parę i referencję do kolejnego węzła.
     */
    protected class Wezel implements Cloneable {
        /**
         * Przechowywana para
         */
        protected Para para;
        /**
         * Referencja do prawego węzła
         */
        protected Wezel right;
        /**
         * Referencja do lewego węzła
         */
        protected Wezel left;
        /**
         * Referencja do ojca
         */
        protected Wezel ojciec;

        /**
         * Konstruktor węzła
         * @param par para w węźle
         * @param nast referencja do prawego węzła
         * @param poprz referencja do lewego węzła
         * @param ojc referencja do ojca
         */
        public Wezel (Para par, Wezel nast, Wezel poprz, Wezel ojc)
        {
            if (par == null) 
            {
                throw new NullPointerException();
            }
            para = par;
            right = nast;
            left = poprz;
            ojciec = ojc;
        }
        
        /**
         * Tworzy podstawę drzewa
         * @param para para podstawy drzewa
         */
        private Wezel(Para para) 
        {
            this(para, null, null, null);
        }

        /**
         * Sprawdza czy istnieje w którymś z węzłów para z zadanym kluczem.
         * @param s nazwa klucza
         * @return prawdę gdy znajdzie, fałsz gdy nie znajdzie
         * @throws IllegalArgumentException  
         */
        public boolean szukaj (String s) throws IllegalArgumentException
        {
            
            Wezel obecny = this;
            while (obecny != null && !obecny.para.klucz.equals(s))
            {
                obecny = (obecny.para.klucz.compareTo(s) > 0) ? obecny.left : obecny.right;
            }
            
            if (obecny == null) 
            {
                return false;
            }
            else 
            {
                return true;
            }
        }
        
        /**
         * Sprawdza czy istnieje w którymś z węzłów para z zadanym kluczem i zwraca ją.
         * @param s nazwa klucza
         * @return węzeł jeśli istnieje, jeśli nie to null
         * @throws IllegalArgumentException  
         */
        public Wezel szukaj2 (String s) throws IllegalArgumentException
        {
            
            Wezel obecny = this;
            while (obecny != null && !obecny.para.klucz.equals(s))
            {
                obecny = (obecny.para.klucz.compareTo(s) > 0) ? obecny.left : obecny.right;
            }
            
            if (obecny == null) {
                return null;
            }
            else {
                return obecny;
            }
        }
        
        /**
         * Szuka największego elementu w drzewie zaczynając od danego węzła
         * @param wezel węzeł od którego węzła zaczynamy
         * @return zwraca węzeł z największą parą
         */
        public Wezel max(Wezel wezel) 
        {
            while(wezel.right != null) 
            {
                wezel = wezel.right;
            }
            return wezel;
        }
        
        /**
         * Znajduje następny węzeł
         * @param s klucz pary w węźle
         * @return węzeł będący następnikiem
         * @throws NullPointerException  
         */
        public Wezel successor(String s) throws NullPointerException
        {
            Wezel wezel = this.szukaj2(s);
            
            if (wezel.right != null) 
            {
                wezel = wezel.right;
                while (wezel.left != null) 
                {
                    wezel = wezel.left;
                }
                return wezel;
            }
            else if (wezel.right == null && wezel != root && wezel != this.max(root)) 
            {
                Wezel parent = wezel.ojciec;
                while (parent != root && parent.para.klucz.compareTo(wezel.para.klucz) < 0) 
                {
                    parent = parent.ojciec;
                }
                return parent;
            }
            else 
            {
                throw new NullPointerException();
            }
        }
        
        /**
         * Usuwa parę z węzła po zadanym kluczu pary.
         * @param s nazwa klucza
         * @return usunięty węzeł
         */
        public Wezel usuń (String s)
        {
            Wezel wezel = this.szukaj2(s);
            if (wezel != null)
            {
                Wezel parent = wezel.ojciec;
                Wezel tmp;
            
                if (wezel.left != null && wezel.right != null) 
                {
                    tmp = this.usuń(this.successor(s).para.klucz);
                    tmp.left = wezel.left;
                    if (tmp.left != null) 
                    {
                        tmp.left.ojciec = tmp;
                    }
                    tmp.right = wezel.right;
                    if (tmp.right != null) 
                    {
                        tmp.right.ojciec = tmp;
                    }
                }
                else 
                {
                    tmp = (wezel.left != null) ? wezel.left : wezel.right;
                }
            
                if (tmp != null) 
                {
                    wezel.ojciec = parent;
                }
                if (parent == null) 
                {
                    root = tmp;
                }
                else if (parent.left == wezel) 
                {
                    parent.left = tmp;
                }
                else 
                {
                    parent.right = tmp;
                }
                return wezel;
            }
            else
            {
                return null;
            }
            
        }  

        /**
         * Funkcja duplikująca węzły.
         * @return węzły w postaci obiektu
         * @throws CloneNotSupportedException  
         */
        @Override
        public Wezel clone () throws CloneNotSupportedException
        {
            try {
                Wezel w = new Wezel(new Para(new String(this.para.klucz), new Double(this.para.wartosc)), this.right, this.left, this.ojciec);    
                if (right!=null) {
                    w.right = right.clone();
                    
                }
                if (left != null) {
                    w.left = left.clone();
                }
                return w;
            }
            catch (CloneNotSupportedException ex) { return null; }
        }

        /**
         * Wypisująca węzły.
         * @return węzły w postaci string
         */
        @Override
        public String toString ()
        {
            String s = "\""+para+"\"";
            if (right!=null) {
                return s+", "+right;
            }
            return s;
        }
        
        /**
         * Drukuje drzewo od najmniejszego do największego klucza (inOrder)
         */
        public void printTree ()
        {
            if (this != null) 
            {
                if (this.left != null)
                {
                    this.left.printTree();
                }
                if (this.ojciec == null)
                {
                    System.out.print("(" + this.para.klucz + " " + this.para.wartosc.intValue() + ")");
                }
                else
                {
                    System.out.print(", (" + this.para.klucz + " " + this.para.wartosc.intValue() + ")");
                }
                if (this.right != null)
                {
                    this.right.printTree();
                }
            }
        }
    }
    
    /**
     * Drzewo przechowujące węzły.
     */
    public Wezel root;
    /**
     * Liczba węzłów
     */
    protected int licznik = 0;
    
    /**
     * Zwiększa licznik węzłów o 1
     */
    private void ZwiększLicznik()
    {
        ++licznik;
    }
    
    /**
     * Zmniejsza ilość węzłów o 1
     */
    private void ZmniejszLicznik() 
    {
        --licznik;
    }
    
    
    /**
     * Drukuje drzewo
     */
    public void printTree()
    {
        System.out.print("{");
        if (root != null)
        {
            root.printTree();
        }
        System.out.print("}");
    }
    
    /**
     * Dodaje nową parę do nowego węzła.
     * @param k nazwa klucza
     * @param w wartość klucza
     */
    @Override
    public void wstaw(String k, double w) {
        if (k.equals("")) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new Wezel(new Para(k, w));
        }
        else {
            Wezel obecny = root;
            if (!root.szukaj(k)) {
                
            
                Wezel parent = null;
                while (obecny != null)
                {
                    parent = obecny;
                    obecny = (obecny.para.klucz.compareTo(k) > 0) ? obecny.left : obecny.right;
                }
                if (parent.para.klucz.compareTo(k) > 0) {
                    parent.left = new Wezel(new Para(k,w), null, null, parent);
                }
                else {
                    parent.right = new Wezel(new Para(k,w), null, null, parent);
                }
            }
        }  
        ZwiększLicznik();
    }

    /**
     * Usuwa węzeł z drzewa.
     * @param k nazwa klucza w parze w węźle
     */
    @Override
    public void usuń(String k) {
        root.usuń(k);
        ZmniejszLicznik();
    }

    /**
     * Sprawdza, czy istnieje w którymś węźle para z zadanym kluczem.
     * @param s nazwa klucza
     * @return root.szukaj
     */
    @Override
    public boolean szukaj(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            return false;
        }
        else {
            return root.szukaj(s);
        }
    }

    /**
     * Zwraca ilość węzłów w drzewie.
     * @return ilość węzłów
     */
    @Override
    public int ile() {
        if (root == null) {
            return 0;
        }
        else {
            return licznik;
        }
    }
    
    /**
     * Duplikuje root z wszystkimi węzłami.
     * @return zduplikowane root
     * @throws CloneNotSupportedException  
     */
    @Override
    public DrzewoBST clone () throws CloneNotSupportedException
    {
            
            DrzewoBST nowe = new DrzewoBST();
            nowe.root = root.clone();
            //nowe.root = new Wezel(new Para(new String(root.para.klucz), new Double(root.para.wartosc)));
            return nowe;
    }
}
