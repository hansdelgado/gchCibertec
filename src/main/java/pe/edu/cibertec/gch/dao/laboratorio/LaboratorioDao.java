package pe.edu.cibertec.gch.dao.laboratorio;

import java.util.List;
import pe.edu.cibertec.gch.dao.BaseDao;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author hans delgado
 */
public interface LaboratorioDao extends BaseDao<Laboratorio> {
    void eliminarPorCodigo(final String codigo);
    Laboratorio consultarPorCodigo(final String codigo);
    List<Laboratorio> listarSegun(final String nombre, final String local, TipoBusqueda tipoBusqueda);
}
