/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.horario;

import com.opensymphony.xwork2.Action;
import java.util.logging.Logger;
import java.util.logging.Level;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author LIBIO
 */
public class GestionHorarioAction extends HorarioBaseAction{
    public String registrar(){
        
        
        Horario horario = new Horario().conCodigo(codigo)
                .conDescripcion(descripcion)
                .conMomentoInicio(horaInicio)
                .conMomentoFin(horaFin)
                .conEstado(EstadoActividad.Activo);

        gestor.registrar(horario);
        return Action.SUCCESS;
    }
    public String actualizar() {
        
        Horario horario = new Horario().conCodigo(codigo)
                .conDescripcion(descripcion)
                .conMomentoInicio(horaInicio)
                .conMomentoFin(horaFin)
                .conEstado(EstadoActividad.Activo);

        gestor.actualizar(horario);
        return Action.SUCCESS;
    }
    public String eliminar() {
        try {
            gestor.eliminarSegun(codigo);
            return Action.SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(GestionHorarioAction.class.getName()).log(Level.SEVERE, null, ex);
            return Action.ERROR;
        }
    }
}
