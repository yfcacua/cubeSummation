/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imaginamos.util;

import com.imaginamos.model.Query;
import com.imaginamos.model.Update;
import com.imaginamos.model.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de traducir la operaciones que ingresan como texto a objetos
 * ya concretos
 *
 * @author Yerson Cacua
 */
public class OperationUtil {

    /**
     * encargada de traducir la operaciones que ingresan como texto a objetos
     * Query o Update
     *
     * @param operations
     * @return
     */
    public static List<Operation> getConcreteOperations(List<String> operations) {
        List<Operation> concreteOperations = new ArrayList<>();
        for (String op : operations) {
            op = op.trim();
            String[] values = op.split(Constant.ESPACIO);
            if (Operation.QUERY.equals(values[0])) {
                Query operationQuery = new Query();
                operationQuery.setType(values[0]);
                operationQuery.setX1(Integer.parseInt(values[1]));
                operationQuery.setY1(Integer.parseInt(values[2]));
                operationQuery.setZ1(Integer.parseInt(values[3]));
                operationQuery.setX2(Integer.parseInt(values[4]));
                operationQuery.setY2(Integer.parseInt(values[5]));
                operationQuery.setZ2(Integer.parseInt(values[6]));
                concreteOperations.add(operationQuery);
            } else if (Operation.UPDATE.equals(values[0])) {
                Update operationUpdate = new Update();
                operationUpdate.setType(values[0]);
                operationUpdate.setX(Integer.parseInt(values[1]));
                operationUpdate.setY(Integer.parseInt(values[2]));
                operationUpdate.setZ(Integer.parseInt(values[3]));
                operationUpdate.setNewValue(Integer.parseInt(values[4]));
                concreteOperations.add(operationUpdate);
            } else {
                throw new RuntimeException("Operation Not Found");
            }
           
        }
        return concreteOperations;
    }
}
