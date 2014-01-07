/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.profesor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import static pe.edu.cibertec.gch.action.profesor.ProfesorBaseAction.LISTA_BASE;
import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author hans delgado
 */
public class MostrarProfesorAction extends ProfesorBaseAction {

    public MostrarProfesorAction() {
    }
    
    public String listar() {
        try {
            listaProfesores = gestor.listarTodos();
        } catch (Exception e) {
            return Action.ERROR;
        }
        return LISTA_BASE;
    }    
    
    public String buscar() {
        try {
            // segun el tipo de codigo obtenemos el tipo de busqueda
            TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusqueda));

            // trae los profesores en la fuente de datos y los expone en la lista
            listaProfesores = gestor
                    .listarSegun(nombres, apellidoPaterno, 
                        apellidoMaterno, tipoBusquedaEnum);
        } catch (NumberFormatException numberFormatException) {
            return Action.ERROR;
        }
        return SUCCESS;
    }
}