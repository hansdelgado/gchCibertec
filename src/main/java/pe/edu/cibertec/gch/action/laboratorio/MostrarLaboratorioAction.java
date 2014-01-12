/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.action.laboratorio;

import com.opensymphony.xwork2.Action;
import static com.opensymphony.xwork2.Action.SUCCESS;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author YESSY
 */
public class MostrarLaboratorioAction extends LaboratorioBaseAction{
    public String listar(){
        try {
            listaLaboratorios = gestor.listarTodos();
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
            listaLaboratorios = gestor
                    .listarSegun(nombre,local, tipoBusquedaEnum);
        } catch (NumberFormatException numberFormatException) {
            return Action.ERROR;
        }
        return SUCCESS;
    }
}