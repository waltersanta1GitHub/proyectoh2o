package com.quimiespel.quimiespelmaven.map;
// Generated May 10, 2017 9:39:18 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Estadomaterial generated by hbm2java
 */
@Entity
@Table(name="estadomaterial"
    ,catalog="quimirespel"
)
public class Estadomaterial  implements java.io.Serializable {


     private Long idEstadoMaterial;
     private String descripcion;

    public Estadomaterial() {
    }

    public Estadomaterial(String descripcion) {
       this.descripcion = descripcion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEstadoMaterial", unique=true, nullable=false)
    public Long getIdEstadoMaterial() {
        return this.idEstadoMaterial;
    }
    
    public void setIdEstadoMaterial(Long idEstadoMaterial) {
        this.idEstadoMaterial = idEstadoMaterial;
    }

    
    @Column(name="Descripcion", length=60)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


