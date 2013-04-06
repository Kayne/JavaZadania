/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onp.wyjątki;

/**
 *
 * @author kayne
 */
public class WyjątekONP extends Exception {

    /**
     * Creates a new instance of
     * <code>WyjątekONP</code> without detail message.
     */
    public WyjątekONP() {
    }

    /**
     * Constructs an instance of
     * <code>WyjątekONP</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public WyjątekONP(String msg) {
        super(msg);
    }
}
