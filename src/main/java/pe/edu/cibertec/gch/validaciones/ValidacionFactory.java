package pe.edu.cibertec.gch.validaciones;

import javax.servlet.http.HttpServletRequest;

/**
 * Determina el objeto que va a efectuar la validacion
 */
public class ValidacionFactory { 
    
    public Validacion obtenerSegun(HttpServletRequest req) {
        if(req.getServletPath().contains("Profesor")) {
            System.out.println("estoy en el factory validacion creando un validacion profesor()");
            return new ValidacionProfesor();
        }
        if(req.getServletPath().contains("Horario")){
            System.out.println("estoy en el factory validacion creando un validacion horario()");
            return new ValidacionHorario();
            
        }    
            
        return null;
    }
}
