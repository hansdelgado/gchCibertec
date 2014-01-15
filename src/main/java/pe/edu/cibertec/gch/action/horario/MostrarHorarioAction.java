/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.horario;

import com.opensymphony.xwork2.Action;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author LIBIO
 */
public class MostrarHorarioAction extends HorarioBaseAction{
    public MostrarHorarioAction() {
    }
    
    public String listar() {
        try {
            listaHorarios = gestor.listarTodos();
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
            listaHorarios = gestor
                    .listarSegun(codigo, descripcion, 
                        estado, tipoBusquedaEnum);
        } catch (NumberFormatException numberFormatException) {
            return Action.ERROR;
        }
        return SUCCESS;
    }
}
