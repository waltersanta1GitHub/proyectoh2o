package com.quimiespel.quimiespelmaven.map;
// Generated May 10, 2017 9:39:18 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FormatosencabezadoId generated by hbm2java
 */
@Embeddable
public class FormatosencabezadoId  implements java.io.Serializable {


     private long idFormatoEncabezado;
     private long empleadosId;
     private long tipoFormatoId;
     private long ciiuId;

    public FormatosencabezadoId() {
    }

    public FormatosencabezadoId(long idFormatoEncabezado, long empleadosId, long tipoFormatoId, long ciiuId) {
       this.idFormatoEncabezado = idFormatoEncabezado;
       this.empleadosId = empleadosId;
       this.tipoFormatoId = tipoFormatoId;
       this.ciiuId = ciiuId;
    }
   


    @Column(name="idFormatoEncabezado", nullable=false)
    public long getIdFormatoEncabezado() {
        return this.idFormatoEncabezado;
    }
    
    public void setIdFormatoEncabezado(long idFormatoEncabezado) {
        this.idFormatoEncabezado = idFormatoEncabezado;
    }


    @Column(name="Empleados_id", nullable=false)
    public long getEmpleadosId() {
        return this.empleadosId;
    }
    
    public void setEmpleadosId(long empleadosId) {
        this.empleadosId = empleadosId;
    }


    @Column(name="TipoFormato_id", nullable=false)
    public long getTipoFormatoId() {
        return this.tipoFormatoId;
    }
    
    public void setTipoFormatoId(long tipoFormatoId) {
        this.tipoFormatoId = tipoFormatoId;
    }


    @Column(name="CIIU_id", nullable=false)
    public long getCiiuId() {
        return this.ciiuId;
    }
    
    public void setCiiuId(long ciiuId) {
        this.ciiuId = ciiuId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FormatosencabezadoId) ) return false;
		 FormatosencabezadoId castOther = ( FormatosencabezadoId ) other; 
         
		 return (this.getIdFormatoEncabezado()==castOther.getIdFormatoEncabezado())
 && (this.getEmpleadosId()==castOther.getEmpleadosId())
 && (this.getTipoFormatoId()==castOther.getTipoFormatoId())
 && (this.getCiiuId()==castOther.getCiiuId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdFormatoEncabezado();
         result = 37 * result + (int) this.getEmpleadosId();
         result = 37 * result + (int) this.getTipoFormatoId();
         result = 37 * result + (int) this.getCiiuId();
         return result;
   }   


}

