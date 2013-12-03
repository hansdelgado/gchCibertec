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
    void modificarPorCodigo(final String codigo,String nombre,String descripcion,String local);
//    ,String pabellon,String salon,int capacidad 
    Laboratorio consultarPorCodigo(final String codigo);
    List<Laboratorio> listarSegun(final String nombre, final String local, TipoBusqueda tipoBusqueda);
}
