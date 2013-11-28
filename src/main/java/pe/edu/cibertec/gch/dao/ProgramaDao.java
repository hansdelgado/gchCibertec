/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;



/**
 *
 * @author JAVA-ADV-LM
 */
public interface ProgramaDao extends BaseDao<Programa> {
      //Profesor consultarPorCodigo(final String codigo);
      public List<Programa> listarTodos();
         public List<Programa> listarSegun(String titulo, String descripcion, String objetivo,TipoBusqueda tipoBusqueda);
}
