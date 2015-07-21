/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imaginamos.model;

/**
 * Clase que representa un punto dentro del cubo y que contiene un valor
 *
 * @author Yerson Cacua
 */
public class Point {

    private int x;
    private int y;
    private int z;
    private long valor;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * getter de x
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * setter de x
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter de y
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * setter de y
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter de z
     *
     * @return
     */
    public int getZ() {
        return z;
    }

    /**
     * setter de z
     *
     * @param z
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * getter de valor
     *
     * @return
     */
    public long getValor() {
        return valor;
    }

    /**
     * setter de valor
     *
     * @param valor
     */
    public void setValor(long valor) {
        this.valor = valor;
    }

}
