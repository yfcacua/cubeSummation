/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * metodo que acutaliza el valor del cubo
     *
     * @param cubo
     * @param update
     */
    public void ejecutar(Cube cubo, com.imaginamos.model.Update update) {
        Point get = cubo.get(update.getX(), update.getY(), update.getZ());
        get.setValor(update.getNewValue());
    }

}
