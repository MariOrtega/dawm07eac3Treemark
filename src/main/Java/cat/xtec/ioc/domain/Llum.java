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
public class Llum extends Article{
    String color;
    boolean fixa;
    String longitud;

    public Llum() {
       super();
    }

    public Llum(String color, boolean fixa, String longitud, String codi, String titol, String descripcio, int numeroUnitats, int numeroVendes) {
        super(codi, titol, descripcio, numeroUnitats, numeroVendes);
        this.color = color;
        this.fixa = fixa;
        this.longitud = longitud;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFixa() {
        return fixa;
    }

    public void setFixa(boolean fixa) {
        this.fixa = fixa;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
}
