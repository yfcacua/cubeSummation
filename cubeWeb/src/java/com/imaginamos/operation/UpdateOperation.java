package com.imaginamos.operation;

import com.imaginamos.model.Point;
import com.imaginamos.model.Cube;

/**
 * Clase que realiza una actualizacion sobre un cubo
 *
 * @author Yerson Cacua
 */
public class UpdateOperation {

    public UpdateOperation() {
    }

    /**
     * metodo que actualiza el valor del cubo
     *
     * @param cubo
     * @param update
     */
    public void ejecutar(Cube cubo, com.imaginamos.model.Update update) {
        Point get = cubo.get(update.getX(), update.getY(), update.getZ());
        get.setValor(update.getNewValue());
    }

}
