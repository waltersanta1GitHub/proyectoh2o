package com.quimiespel.quimiespelmaven.map;
// Generated May 10, 2017 9:39:18 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ciiu generated by hbm2java
 */
@Entity
@Table(name="ciiu"
    ,catalog="quimirespel"
)
public class Ciiu  implements java.io.Serializable {


     private Long idCiiu;
     private String codigo;
     private String descripcion;

    public Ciiu() {
    }

	
    public Ciiu(String codigo) {
        this.codigo = codigo;
    }
    public Ciiu(String codigo, String descripcion) {
       this.codigo = codigo;
       this.descripcion = descripcion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCiiu", unique=true, nullable=false)
    public Long getIdCiiu() {
        return this.idCiiu;
    }
    
    public void setIdCiiu(Long idCiiu) {
        this.idCiiu = idCiiu;
    }

    
    @Column(name="Codigo", nullable=false, length=8)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="Descripcion", length=200)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

