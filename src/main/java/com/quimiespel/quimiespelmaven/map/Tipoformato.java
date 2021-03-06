package com.quimiespel.quimiespelmaven.map;
// Generated May 10, 2017 9:39:18 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tipoformato generated by hbm2java
 */
@Entity
@Table(name="tipoformato"
    ,catalog="quimirespel"
)
public class Tipoformato  implements java.io.Serializable {


     private Long idTipoFormato;
     private String descripcion;

    public Tipoformato() {
    }

    public Tipoformato(String descripcion) {
       this.descripcion = descripcion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idTipoFormato", unique=true, nullable=false)
    public Long getIdTipoFormato() {
        return this.idTipoFormato;
    }
    
    public void setIdTipoFormato(Long idTipoFormato) {
        this.idTipoFormato = idTipoFormato;
    }

    
    @Column(name="Descripcion", length=70)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


