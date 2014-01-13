/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.curso;

import com.opensymphony.xwork2.Action;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author ferna012
 */
public class MostrarCursoAction extends CursoBaseAction {
    public MostrarCursoAction(){
    
    }
    
    public String listar() {
        try {
            listaCursos = gestor.listarTodos();
        } catch (Exception e) {
            return Action.ERROR;
        }
        return LISTA_BASE;
    }
    
    public String buscar() {
       try {
                TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusqueda));
                
                listaCursos = gestor.listarSegunCurso(codigo, nombre, descripcion,tipoBusquedaEnum);
           
           } catch (NumberFormatException numberFormatException) {
                return Action.ERROR;
        }
        return SUCCESS;
   
    }
    
}
