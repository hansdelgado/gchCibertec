package pe.edu.cibertec.gch.dao.profesor;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;

public class ProfesorDaoImplMemoria implements ProfesorDao {

    private static ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    
    @Override
    public void registrar(Profesor profesor) {
        profesores.add(profesor);
    }

    @Override
    public List<Profesor> listarTodos() {
        return profesores;
    }

    @Override
    public void eliminarPorCodigo(final String codigo) {
        // Al eliminar, el estado del profesor 
        // se cambia a inactivo
        Profesor profesor = consultarPorCodigo(codigo);
        profesor.setEstado(EstadoProfesor.Inactivo);
    }

    @Override
    public Profesor consultarPorCodigo(final String codigo) {
        Profesor profesor = new Profesor() {{setCodigo(codigo);}};
        return profesores.get(profesores.indexOf(profesor));
    }

    public void borrarTodos() {
        profesores.clear();
    }

    @Override
    public List<Profesor> listarSegun(String nombre, String apellidoPaterno, String apellidoMaterno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
