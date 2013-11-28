
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao.horario;

import java.util.List;
import pe.edu.cibertec.gch.dao.BaseDao;
import pe.edu.cibertec.gch.modelo.Horario;
/**
 *
 * @author LIBIO
 */
public interface HorarioDao extends BaseDao<Horario>  {
    void eliminarPorCodigo(final String codigo);
    Horario consultarPorCodigo(final String codigo);
    List<Horario> listarSegun(final String nombre, String apellidoPaterno, String apellidoMaterno);
    void actualizar(Horario horario);
}
