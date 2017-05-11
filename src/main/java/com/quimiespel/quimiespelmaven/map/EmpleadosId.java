package com.quimiespel.quimiespelmaven.map;
// Generated May 10, 2017 9:39:18 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpleadosId generated by hbm2java
 */
@Embeddable
public class EmpleadosId  implements java.io.Serializable {


     private long idEmpleado;
     private long ciudadesId;
     private long cargosId;
     private long tipoDocumentoId;
     private long areasId;

    public EmpleadosId() {
    }

    public EmpleadosId(long idEmpleado, long ciudadesId, long cargosId, long tipoDocumentoId, long areasId) {
       this.idEmpleado = idEmpleado;
       this.ciudadesId = ciudadesId;
       this.cargosId = cargosId;
       this.tipoDocumentoId = tipoDocumentoId;
       this.areasId = areasId;
    }
   


    @Column(name="idEmpleado", nullable=false)
    public long getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


    @Column(name="Ciudades_id", nullable=false)
    public long getCiudadesId() {
        return this.ciudadesId;
    }
    
    public void setCiudadesId(long ciudadesId) {
        this.ciudadesId = ciudadesId;
    }


    @Column(name="Cargos_id", nullable=false)
    public long getCargosId() {
        return this.cargosId;
    }
    
    public void setCargosId(long cargosId) {
        this.cargosId = cargosId;
    }


    @Column(name="TipoDocumento_id", nullable=false)
    public long getTipoDocumentoId() {
        return this.tipoDocumentoId;
    }
    
    public void setTipoDocumentoId(long tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }


    @Column(name="Areas_id", nullable=false)
    public long getAreasId() {
        return this.areasId;
    }
    
    public void setAreasId(long areasId) {
        this.areasId = areasId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmpleadosId) ) return false;
		 EmpleadosId castOther = ( EmpleadosId ) other; 
         
		 return (this.getIdEmpleado()==castOther.getIdEmpleado())
 && (this.getCiudadesId()==castOther.getCiudadesId())
 && (this.getCargosId()==castOther.getCargosId())
 && (this.getTipoDocumentoId()==castOther.getTipoDocumentoId())
 && (this.getAreasId()==castOther.getAreasId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdEmpleado();
         result = 37 * result + (int) this.getCiudadesId();
         result = 37 * result + (int) this.getCargosId();
         result = 37 * result + (int) this.getTipoDocumentoId();
         result = 37 * result + (int) this.getAreasId();
         return result;
   }   


}

