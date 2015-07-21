package com.imaginamos.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la estructura del cubo
 * @author Yerson Cacua
 */
public class Cube {
    /**
     *  matriz para indexar las pociciones y hacer mas rapido al acceso en 
     *  las operaciones de consulta
     */
    private final Point[][][] contenido;
    private final List<Point> lineal;

    public Cube(int tamano) {
        this.contenido = new Point[tamano][tamano][tamano];
        lineal = new ArrayList<>();
    }
    /**
     * retorna la representacion lineal del cubo perimitiendo almacenar solo
     * los valores que tiene un valor mayor que cero
     * @return 
     */
    public List<Point> getLineal() {
        return lineal;
    }
    /**
     *  metodo encargado de consultar un paosicion dada un cordenada
     *  este metodo permite una carga lazy en la construccion del cubo
     * @param x
     * @param y
     * @param z
     * @return Point determinada por las coordenadas x,y,z
     */
    public Point get(int x, int y, int z) {
        Point point = contenido[x-1][y-1][z-1];
        if (point == null) {
            point = new Point(x, y, z);
            lineal.add(point);
            contenido[x-1][y-1][z-1] = point;
        }
        return point;
    }

}
