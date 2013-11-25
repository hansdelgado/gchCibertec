package pe.edu.cibertec.gch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *
 * @author Student
 */
@Target(ElementType.METHOD)
public @interface Inestable {
  
    public abstract SituacionInestable situacion();
    
}
