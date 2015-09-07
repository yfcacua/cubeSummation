package com.imaginamos.model;

/**
 * clase que representa la estructura de un update
 *
 * @author Yerson Cacua
 */
public class Update extends Operation {

    private int x;
    private int y;
    private int z;
    private long newValue;
    private String type;

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
     * getter de new value
     *
     * @return
     */
    public long getNewValue() {
        return newValue;
    }

    /**
     * setter de new value
     *
     * @param newValue
     */
    public void setNewValue(long newValue) {
        this.newValue = newValue;
    }

}
