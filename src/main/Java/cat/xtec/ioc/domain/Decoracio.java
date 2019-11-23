/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.domain;

/**
 *
 * @author Mari
 */
public class Decoracio extends Article {
    String tipus;
    String color;
    String mida;

    public Decoracio() {
        super();
    }

    public Decoracio(String tipus, String color, String mida, String codi, String titol, String descripcio, int numeroUnitats, int numeroVendes) {
        super(codi, titol, descripcio, numeroUnitats, numeroVendes);
        this.tipus = tipus;
        this.color = color;
        this.mida = mida;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMida() {
        return mida;
    }

    public void setMida(String mida) {
        this.mida = mida;
    }
    
}
