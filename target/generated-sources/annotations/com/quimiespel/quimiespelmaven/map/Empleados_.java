package com.quimiespel.quimiespelmaven.map;

import com.quimiespel.quimiespelmaven.map.EmpleadosId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T10:47:54")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, Date> fechanacimiento;
    public static volatile SingularAttribute<Empleados, String> apellido;
    public static volatile SingularAttribute<Empleados, String> documento;
    public static volatile SingularAttribute<Empleados, String> telefonoMovil;
    public static volatile SingularAttribute<Empleados, EmpleadosId> id;
    public static volatile SingularAttribute<Empleados, String> nombre;
    public static volatile SingularAttribute<Empleados, String> email;
    public static volatile SingularAttribute<Empleados, String> telefonoFijo;

}