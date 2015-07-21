/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imaginamos.model;

import java.util.List;

/**
 * Clase que representa la estructura de un caso de prueba
 *
 * @author Yerson Cacua
 */
public class Case {

    /**
     * numero de operaciones
     */
    private int n;
    /**
     * lista de operaciones
     */
    private List<String> operations;

    /**
     * getter de n
     *
     * @return
     */
    public int getN() {
        return n;
    }

    /**
     * setter de n
     *
     * @param n
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * getter de operaciones
     *
     * @return
     */
    public List<String> getOperations() {
        return operations;
    }

    /**
     * setter de operaciones
     *
     * @param operations
     */
    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

}
