/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.curso;

import com.opensymphony.xwork2.Action;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.EstadoCurso;

/**
 *
 * @author ferna012
 */
public class GestionCursoAction extends CursoBaseAction {
    public String registrar(){
    
        Curso curso = new Curso().conCodigo(codigo)
                .conNombre(nombre)
                .conDescripcion(descripcion)
                .conObjetivos(objetivos)
                .conRequisitos(requisitos)
                .conDuracion(duracion)
                .conEstado(EstadoCurso.Activo);
                //.conEstado(EstadoActividad.Valido);

        gestor.registrar(curso);
        //gestor.registrar(profesor);
        return Action.SUCCESS;
    
    }
    
    public String actualizar() {
        Curso curso = new Curso().conCodigo(codigo)
                .conNombre(nombre)
                .conDescripcion(descripcion)
                .conObjetivos(objetivos)
                .conRequisitos(requisitos)
                .conDuracion(duracion)
                .conEstado(EstadoCurso.obtenerSegun(estado));
                //.conEstado(EstadoActividad.Valido);
                

        //gestor.actualizar(profesor);
        gestor.actualizar(curso);
        return Action.SUCCESS;
    }
    
    public String eliminar() {
        try {
	    gestor.eliminarPorCodigo(codigo);
            return Action.SUCCESS;
        } catch (DatosInvalidosException ex) {
            Logger.getLogger(GestionCursoAction.class.getName()).log(Level.SEVERE, null, ex);
            return Action.ERROR;
        }

        
    }
    
}
