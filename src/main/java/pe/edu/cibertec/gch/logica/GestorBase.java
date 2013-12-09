package pe.edu.cibertec.gch.logica;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author hans delgado
 */
public interface GestorBase<T> {
    public List<T> listarTodos();
    void eliminarPorCodigo(final String codigo);
    void modificarPorCodigo(Programa pro);
    T consultarPorCodigo(final String codigo);
    void registrar(T entidad);
}
