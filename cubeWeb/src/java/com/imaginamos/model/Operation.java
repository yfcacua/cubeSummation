/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imaginamos.model;

/**
 *  clase que representa la base de una operacion
 * @author Yerson Cacua
 */
public class Operation {
    
    public static final String QUERY = "QUERY";
    public static final String UPDATE = "UPDATE";
    private String type;      
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }
}
