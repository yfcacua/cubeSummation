package com.imaginamos.delegator;

import com.imaginamos.model.Case;
import com.imaginamos.model.Cube;
import com.imaginamos.model.Query;
import com.imaginamos.model.Update;
import com.imaginamos.model.Operation;
import com.imaginamos.operation.QueryOperation;
import com.imaginamos.operation.UpdateOperation;
import com.imaginamos.util.OperationUtil;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author listman
 */
public class CubeDelegator {

    private final QueryOperation summation;
    private final UpdateOperation update;

    public CubeDelegator() {
        this.summation = new QueryOperation();
        this.update = new UpdateOperation();
    }

    /**
     * metodo encargado de realizar todas las operaciones que estan en lo casos 
     * de entrada
     * @param cases
     * @return
     */
    public List<String> processingCases(List<Case> cases) {
        List<String> list = new ArrayList<>();
        for (Case _case : cases) {
            Cube cube = new Cube(_case.getN());
            for (Operation operation : OperationUtil.getConcreteOperations(_case.getOperations())) {
                if (Operation.QUERY.equals(operation.getType())) {
                    String resultado = summation.ejecutar(cube, (Query) operation).toString();
                    list.add(resultado);
                } else if (Operation.UPDATE.equals(operation.getType())) {
                    update.ejecutar(cube, (Update) operation);
                }

            }
        }
        return list;
    }

}
