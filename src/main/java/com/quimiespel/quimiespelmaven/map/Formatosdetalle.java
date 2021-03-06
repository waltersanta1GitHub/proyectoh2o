package com.quimiespel.quimiespelmaven.map;
// Generated May 10, 2017 9:39:18 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Formatosdetalle generated by hbm2java
 */
@Entity
@Table(name="formatosdetalle"
    ,catalog="quimirespel"
)
public class Formatosdetalle  implements java.io.Serializable {


     private FormatosdetalleId id;
     private String nombreResiduo;
     private int idLinea;
     private int cantidad;
     private Date fechaTempA;
     private Date fechaTempB;
     private Date fechaTempC;
     private Date fechaTempD;
     private Date horaTempA;
     private Date horaTempB;
     private Date horaTempC;
     private Date horaTempD;
     private Long enteroTempA;
     private Long enteroTempB;
     private Long enteroTempC;
     private Long enteroTempD;
     private Boolean booleanoTempA;
     private Boolean booleanoTempB;
     private Boolean booleanoTempC;
     private Boolean booleanoTempD;
     private String cadenaTempA;
     private String cadenaTempB;
     private String cadenaTempC;
     private String cadenaTempD;
     private String cadenaTempE;
     private String cadenaTempF;
     private String cadenaTempG;
     private String cadenaTempH;

    public Formatosdetalle() {
    }

	
    public Formatosdetalle(FormatosdetalleId id, String nombreResiduo, int idLinea, int cantidad) {
        this.id = id;
        this.nombreResiduo = nombreResiduo;
        this.idLinea = idLinea;
        this.cantidad = cantidad;
    }
    public Formatosdetalle(FormatosdetalleId id, String nombreResiduo, int idLinea, int cantidad, Date fechaTempA, Date fechaTempB, Date fechaTempC, Date fechaTempD, Date horaTempA, Date horaTempB, Date horaTempC, Date horaTempD, Long enteroTempA, Long enteroTempB, Long enteroTempC, Long enteroTempD, Boolean booleanoTempA, Boolean booleanoTempB, Boolean booleanoTempC, Boolean booleanoTempD, String cadenaTempA, String cadenaTempB, String cadenaTempC, String cadenaTempD, String cadenaTempE, String cadenaTempF, String cadenaTempG, String cadenaTempH) {
       this.id = id;
       this.nombreResiduo = nombreResiduo;
       this.idLinea = idLinea;
       this.cantidad = cantidad;
       this.fechaTempA = fechaTempA;
       this.fechaTempB = fechaTempB;
       this.fechaTempC = fechaTempC;
       this.fechaTempD = fechaTempD;
       this.horaTempA = horaTempA;
       this.horaTempB = horaTempB;
       this.horaTempC = horaTempC;
       this.horaTempD = horaTempD;
       this.enteroTempA = enteroTempA;
       this.enteroTempB = enteroTempB;
       this.enteroTempC = enteroTempC;
       this.enteroTempD = enteroTempD;
       this.booleanoTempA = booleanoTempA;
       this.booleanoTempB = booleanoTempB;
       this.booleanoTempC = booleanoTempC;
       this.booleanoTempD = booleanoTempD;
       this.cadenaTempA = cadenaTempA;
       this.cadenaTempB = cadenaTempB;
       this.cadenaTempC = cadenaTempC;
       this.cadenaTempD = cadenaTempD;
       this.cadenaTempE = cadenaTempE;
       this.cadenaTempF = cadenaTempF;
       this.cadenaTempG = cadenaTempG;
       this.cadenaTempH = cadenaTempH;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idFormatoDetalle", column=@Column(name="idFormatoDetalle", nullable=false) ), 
        @AttributeOverride(name="estadoMaterialId", column=@Column(name="EstadoMaterial_id", nullable=false) ), 
        @AttributeOverride(name="embalajesId", column=@Column(name="Embalajes_id", nullable=false) ), 
        @AttributeOverride(name="unidadesId", column=@Column(name="Unidades_id", nullable=false) ), 
        @AttributeOverride(name="formatosEncabezadoId", column=@Column(name="FormatosEncabezado_id", nullable=false) ) } )
    public FormatosdetalleId getId() {
        return this.id;
    }
    
    public void setId(FormatosdetalleId id) {
        this.id = id;
    }

    
    @Column(name="NombreResiduo", nullable=false, length=250)
    public String getNombreResiduo() {
        return this.nombreResiduo;
    }
    
    public void setNombreResiduo(String nombreResiduo) {
        this.nombreResiduo = nombreResiduo;
    }

    
    @Column(name="idLinea", nullable=false)
    public int getIdLinea() {
        return this.idLinea;
    }
    
    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    
    @Column(name="Cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaTempA", length=10)
    public Date getFechaTempA() {
        return this.fechaTempA;
    }
    
    public void setFechaTempA(Date fechaTempA) {
        this.fechaTempA = fechaTempA;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaTempB", length=10)
    public Date getFechaTempB() {
        return this.fechaTempB;
    }
    
    public void setFechaTempB(Date fechaTempB) {
        this.fechaTempB = fechaTempB;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaTempC", length=10)
    public Date getFechaTempC() {
        return this.fechaTempC;
    }
    
    public void setFechaTempC(Date fechaTempC) {
        this.fechaTempC = fechaTempC;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaTempD", length=10)
    public Date getFechaTempD() {
        return this.fechaTempD;
    }
    
    public void setFechaTempD(Date fechaTempD) {
        this.fechaTempD = fechaTempD;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HoraTempA", length=8)
    public Date getHoraTempA() {
        return this.horaTempA;
    }
    
    public void setHoraTempA(Date horaTempA) {
        this.horaTempA = horaTempA;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HoraTempB", length=8)
    public Date getHoraTempB() {
        return this.horaTempB;
    }
    
    public void setHoraTempB(Date horaTempB) {
        this.horaTempB = horaTempB;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HoraTempC", length=8)
    public Date getHoraTempC() {
        return this.horaTempC;
    }
    
    public void setHoraTempC(Date horaTempC) {
        this.horaTempC = horaTempC;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HoraTempD", length=8)
    public Date getHoraTempD() {
        return this.horaTempD;
    }
    
    public void setHoraTempD(Date horaTempD) {
        this.horaTempD = horaTempD;
    }

    
    @Column(name="EnteroTempA")
    public Long getEnteroTempA() {
        return this.enteroTempA;
    }
    
    public void setEnteroTempA(Long enteroTempA) {
        this.enteroTempA = enteroTempA;
    }

    
    @Column(name="EnteroTempB")
    public Long getEnteroTempB() {
        return this.enteroTempB;
    }
    
    public void setEnteroTempB(Long enteroTempB) {
        this.enteroTempB = enteroTempB;
    }

    
    @Column(name="EnteroTempC")
    public Long getEnteroTempC() {
        return this.enteroTempC;
    }
    
    public void setEnteroTempC(Long enteroTempC) {
        this.enteroTempC = enteroTempC;
    }

    
    @Column(name="EnteroTempD")
    public Long getEnteroTempD() {
        return this.enteroTempD;
    }
    
    public void setEnteroTempD(Long enteroTempD) {
        this.enteroTempD = enteroTempD;
    }

    
    @Column(name="BooleanoTempA")
    public Boolean getBooleanoTempA() {
        return this.booleanoTempA;
    }
    
    public void setBooleanoTempA(Boolean booleanoTempA) {
        this.booleanoTempA = booleanoTempA;
    }

    
    @Column(name="BooleanoTempB")
    public Boolean getBooleanoTempB() {
        return this.booleanoTempB;
    }
    
    public void setBooleanoTempB(Boolean booleanoTempB) {
        this.booleanoTempB = booleanoTempB;
    }

    
    @Column(name="BooleanoTempC")
    public Boolean getBooleanoTempC() {
        return this.booleanoTempC;
    }
    
    public void setBooleanoTempC(Boolean booleanoTempC) {
        this.booleanoTempC = booleanoTempC;
    }

    
    @Column(name="BooleanoTempD")
    public Boolean getBooleanoTempD() {
        return this.booleanoTempD;
    }
    
    public void setBooleanoTempD(Boolean booleanoTempD) {
        this.booleanoTempD = booleanoTempD;
    }

    
    @Column(name="CadenaTempA", length=260)
    public String getCadenaTempA() {
        return this.cadenaTempA;
    }
    
    public void setCadenaTempA(String cadenaTempA) {
        this.cadenaTempA = cadenaTempA;
    }

    
    @Column(name="CadenaTempB", length=260)
    public String getCadenaTempB() {
        return this.cadenaTempB;
    }
    
    public void setCadenaTempB(String cadenaTempB) {
        this.cadenaTempB = cadenaTempB;
    }

    
    @Column(name="CadenaTempC", length=260)
    public String getCadenaTempC() {
        return this.cadenaTempC;
    }
    
    public void setCadenaTempC(String cadenaTempC) {
        this.cadenaTempC = cadenaTempC;
    }

    
    @Column(name="CadenaTempD", length=260)
    public String getCadenaTempD() {
        return this.cadenaTempD;
    }
    
    public void setCadenaTempD(String cadenaTempD) {
        this.cadenaTempD = cadenaTempD;
    }

    
    @Column(name="CadenaTempE", length=260)
    public String getCadenaTempE() {
        return this.cadenaTempE;
    }
    
    public void setCadenaTempE(String cadenaTempE) {
        this.cadenaTempE = cadenaTempE;
    }

    
    @Column(name="CadenaTempF", length=260)
    public String getCadenaTempF() {
        return this.cadenaTempF;
    }
    
    public void setCadenaTempF(String cadenaTempF) {
        this.cadenaTempF = cadenaTempF;
    }

    
    @Column(name="CadenaTempG", length=260)
    public String getCadenaTempG() {
        return this.cadenaTempG;
    }
    
    public void setCadenaTempG(String cadenaTempG) {
        this.cadenaTempG = cadenaTempG;
    }

    
    @Column(name="CadenaTempH", length=260)
    public String getCadenaTempH() {
        return this.cadenaTempH;
    }
    
    public void setCadenaTempH(String cadenaTempH) {
        this.cadenaTempH = cadenaTempH;
    }




}


