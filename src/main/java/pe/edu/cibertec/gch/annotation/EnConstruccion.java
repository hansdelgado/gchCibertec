package pe.edu.cibertec.gch.annotation;

/**
 *
 * @author hdelgado
 */
public @interface EnConstruccion {
    String owner() default "Hans Delgado";
    String value() default "Object is Under Construction.";
    String createdBy() default "Hans Delgado";
    String lastChanged() default "13/11/2013";    
}
