package arqSw.Hibernate;
// Generated 19/03/2017 10:22:30 PM by Hibernate Tools 3.6.0



/**
 * Camiseta generated by hbm2java
 */
public class Camiseta  implements java.io.Serializable {


     private Integer idCamiseta;
     private Venta venta;
     private String talla;
     private String color;
     private String material;

    public Camiseta() {
    }

	
    public Camiseta(Venta venta) {
        this.venta = venta;
    }
    public Camiseta(Venta venta, String talla, String color, String material) {
       this.venta = venta;
       this.talla = talla;
       this.color = color;
       this.material = material;
    }
   
    public Integer getIdCamiseta() {
        return this.idCamiseta;
    }
    
    public void setIdCamiseta(Integer idCamiseta) {
        this.idCamiseta = idCamiseta;
    }
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public String getTalla() {
        return this.talla;
    }
    
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getMaterial() {
        return this.material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }




}


