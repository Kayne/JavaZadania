/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drzewabinarnychposzukiwan.narzedzia;

/**
 * Interfejs słownik
 * @author kayne
 */
public interface Slownik {
    /**
     * Dodaje nowy element do słownika.
     * @param k nazwa klucza
     * @param w wartoś klucza
     */
    void wstaw(String k, double w);
    /**
     * Usuwa element z słownika po jego kluczu.
     * @param k nazwa klucza
     */
    void usuń(String k);
    /**
     * Wyszykuje w słowniku parę o zadanym kluczu.
     * @param s nazwa klucza
     * @return zwraca prawdę gdy znajdzie klucz
     */
    boolean szukaj(String s);
    /**
     * Zlicza i zwraca ilość elementów słownika.
     * @return liczbę elementów
     */
    int ile();
}
