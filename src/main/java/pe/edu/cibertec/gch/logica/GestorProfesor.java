package pe.edu.cibertec.gch.logica;

import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDao;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 * Realiza operaciones relacionadas al profesor.
 */
public class GestorProfesor {

    private ProfesorDao profesorDao;
    
    public GestorProfesor() {
        profesorDao = FactoryDao
                .getFactory(FactoryDao.MYBATIS)
                .getProfesorDao();
    }

    public void registrar(Profesor profesor) {
        profesorDao.registrar(profesor);
    }

    public void actualizar(Profesor profesor) {
        profesorDao.actualizar(profesor);
    }

    public void eliminar(Profesor profesor) {
        profesorDao.eliminarPorCodigo(profesor.getCodigo());
    }

    public List<Profesor> listarSegun(String nombres,
            String apellidoPaterno, String apellidoMaterno, TipoBusqueda tipoBusqueda) {
        List<Profesor> encontrados = new LinkedList<>();
        for (Profesor profesor : listarTodos()) {
            switch (tipoBusqueda) {
                case Completa:
                    if (apellidoPaterno.equalsIgnoreCase(profesor.getApellidoPaterno())
                            || apellidoMaterno.equalsIgnoreCase(profesor.getApellidoMaterno())
                            || nombres.equalsIgnoreCase(profesor.getNombres())) {
                        encontrados.add(profesor);
                    }
                    break;
                case Parcial:
                    if ((!apellidoPaterno.isEmpty() && profesor.getApellidoPaterno().contains(apellidoPaterno))
                            || (!apellidoMaterno.isEmpty() && profesor.getApellidoMaterno().contains(apellidoMaterno))
                            || (!nombres.isEmpty() && profesor.getNombres().contains(nombres))) {
                        encontrados.add(profesor);
                    }
                    break;
                default:
                    break;
            }
        }
        return encontrados;
    }

    public List<Profesor> listarTodos() {
        return profesorDao.listarTodos();
    }

    public void borrarTodos() {
        profesorDao.borrarTodos();
    }

    public void eliminarSegun(String codigo) throws DatosInvalidosException {
        Profesor profesorAEliminar = consultarSegun(codigo);
        profesorAEliminar.setEstado(EstadoProfesor.Inactivo);

    }

    public Profesor consultarSegun(final String codigo) {
        return profesorDao.consultarPorCodigo(codigo);
    }
}
