package com.imaginamos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la estructura del cubo
 *
 * @author Yerson Cacua
 */
public class Cube {

    /**
     * matriz para indexar las posiciones y hacer mas rapido al acceso en las
     * operaciones de consulta
     */
    private final Point[][][] contenido;
    private final List<Point> lineal;

    public Cube(int tamano) {
        this.contenido = new Point[tamano][tamano][tamano];
        lineal = new ArrayList<>();
    }

    /**
     * retorna la representacion lineal del cubo la cual son las partes del cubo
     * que tiene un valor mayor que cero
     *
     * @return lineal partes del cubo que tiene un valor mayor a cero
     */
    public List<Point> getLineal() {
        return lineal;
    }

    /**
     * metodo encargado de consultar un paosicion dada un cordenada este metodo
     * permite una carga lazy en la construccion del cubo
     *
     * @param x
     * @param y
     * @param z
     * @return Point determinada por las coordenadas x,y,z
     */
    public Point get(int x, int y, int z) {
        Point point = contenido[x - 1][y - 1][z - 1];
        if (point == null) {
            point = new Point(x, y, z);
            lineal.add(point);
            contenido[x - 1][y - 1][z - 1] = point;
        }
        return point;
    }

}
