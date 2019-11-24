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
public class Arbre extends Article{
    public String altura;
    public String material;
    public String color;
    
  public Arbre(){
   super();
  };

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Arbre(String codi,String titol, String descripcio,int numeroUnitats,int numeroVendes,String altura, String material, String color) {
        super(codi,titol,descripcio,numeroUnitats,numeroVendes);
        this.altura = altura;
        this.material = material;
        this.color = color;
    }
  
}
