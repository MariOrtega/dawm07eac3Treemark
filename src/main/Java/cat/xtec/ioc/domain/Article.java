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
public class Article {
 public String codi;
 public String titol;
 public String descripcio ;
 public int numeroUnitats;
 public int numeroVendes;

    public Article() {
    }

    public Article(String codi, String titol, String descripcio, int numeroUnitats, int numeroVendes) {
        this.codi = codi;
        this.titol = titol;
        this.descripcio = descripcio;
        this.numeroUnitats = numeroUnitats;
        this.numeroVendes = numeroVendes;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNumeroUnitats() {
        return numeroUnitats;
    }

    public void setNumeroUnitats(int numeroUnitats) {
        this.numeroUnitats = numeroUnitats;
    }

    public int getNumeroVendes() {
        return numeroVendes;
    }

    public void setNumeroVendes(int numeroVendes) {
        this.numeroVendes = numeroVendes;
    }
 
}
