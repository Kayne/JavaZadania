/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 * Interfejs zapewniający funkcje zmiany ustawień w głównej ramce, jak i w ramce ustawień.
 * @author kayne
 */
public interface InterfejsUstawien {
    
    /**
     * Ustawia checkbox odpowiadający za Oznaczenie Pól na prawdziwy, jeśli tak wskazują ustawienia.
     */
    void setOznaczeniePól();
    /**
     * Ustawia radio odpowiadające za ustalenie, kto zaczyna partię.
     */
    void setKtoZaczyna();
    /**
     * Ustawia checkbox odpowiadający za Skreślenie Pól na prawdziwy, jeśli tak wskazują ustawienia.
     */
    void setSkreśleniePól();
}
