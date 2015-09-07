package com.imaginamos.model;

/**
 * clase que representa la base de una operación
 *
 * @author Yerson Cacua
 */
public class Operation {

    public static final String QUERY = "QUERY";
    public static final String UPDATE = "UPDATE";
    private String type;

    /**
     * getter de Type
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * setter de Type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
