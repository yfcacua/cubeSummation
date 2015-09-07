package com.imaginamos.model;

/**
 * clase que representa la estrucutura de una consulta
 *
 * @author Yerson Cacua
 */
public class Query extends Operation {

    private long x1;
    private long x2;
    private long y1;
    private long y2;
    private long z1;
    private long z2;
    private String type;

    /**
     * getter de x1
     *
     * @return
     */
    public long getX1() {
        return x1;
    }

    /**
     * setter de x1
     *
     * @param x1
     */
    public void setX1(long x1) {
        this.x1 = x1;
    }

    /**
     * getter de x2
     *
     * @return
     */
    public long getX2() {
        return x2;
    }

    /**
     * setter de x2
     *
     * @param x2
     */
    public void setX2(long x2) {
        this.x2 = x2;
    }

    /**
     * getter de y1
     *
     * @return
     */
    public long getY1() {
        return y1;
    }

    /**
     * setter de y1
     *
     * @param y1
     */
    public void setY1(long y1) {
        this.y1 = y1;
    }

    /**
     * getter de y2
     *
     * @return
     */
    public long getY2() {
        return y2;
    }

    /**
     * setter y2
     *
     * @param y2
     */
    public void setY2(long y2) {
        this.y2 = y2;
    }

    /**
     * getter de z1
     *
     * @return
     */
    public long getZ1() {
        return z1;
    }

    /**
     * setter de z1
     *
     * @param z1
     */
    public void setZ1(long z1) {
        this.z1 = z1;
    }

    /**
     * getter de z2
     *
     * @return
     */
    public long getZ2() {
        return z2;
    }

    /**
     * setter de z2
     *
     * @param z2
     */
    public void setZ2(long z2) {
        this.z2 = z2;
    }
}
