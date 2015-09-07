package com.imaginamos.operation;

import com.imaginamos.model.Cube;
import com.imaginamos.model.Point;
import com.imaginamos.model.Query;

/**
 * Clase que representa la ejecucion de una query sobre un cubo
 *
 * @author Yerson Cacua
 */
public class QueryOperation {

    public QueryOperation() {
    }

    /**
     * Metodo que reliza la query
     *
     * @param cube
     * @param query
     * @return total  
     */
    public Long ejecutar(Cube cube, Query query) {
        Long total = 0l;
        for (Point point : cube.getLineal()) {
            if (between(point.getX(), query.getX1(), query.getX2())
                    && between(point.getY(), query.getY1(), query.getY2())
                    && between(point.getZ(), query.getZ1(), query.getZ2())) {
                total += point.getValor();
            }
        }
        return total;
    }

    /**
     * metodo que permite comparar si un valor esta en el rango
     *
     * @param valor
     * @param limiteInferior
     * @param limiteSuperior
     * @return true or false
     */
    private boolean between(long valor, long limiteInferior, long limiteSuperior) {
        return valor >= limiteInferior && valor <= limiteSuperior;
    }

}
