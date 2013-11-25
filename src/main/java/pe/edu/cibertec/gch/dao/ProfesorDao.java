package pe.edu.cibertec.gch.dao;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 *
 * @author hans delgado
 */
public interface ProfesorDao extends BaseDao<Profesor> {
    void eliminarPorCodigo(final String codigo);
    Profesor consultarPorCodigo(final String codigo);
    List<Profesor> listarSegun(final String nombre, String apellidoPaterno, String apellidoMaterno);
    void actualizar(Profesor profesor);
}
