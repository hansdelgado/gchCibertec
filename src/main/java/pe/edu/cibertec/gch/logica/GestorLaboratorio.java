package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDao;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 * Realiza operaciones relacionadas al profesor.
 */
public class GestorLaboratorio implements GestorBase<Laboratorio> {
    
    private static ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
    LaboratorioDao dao = FactoryDao.getInstance().getLaboratorioDao();
 
    @Override
    public void registrar(Laboratorio laboratorio) {
        dao.registrar(laboratorio);
    }
      
    @Override
    public List<Laboratorio> listarTodos() {
        return dao.listarTodos();
    }

     public List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda) {
        return dao.listarSegun(nombre, local, tipoBusqueda);
    }
    
    
    @Override
    public void eliminarPorCodigo(final String codigo) {
        dao.eliminarPorCodigo(codigo);
    }

    
    @Override
    public Laboratorio consultarPorCodigo(final String codigo) {
        return dao.consultarPorCodigo(codigo);
                
    }

    protected void borrarTodos() {
//        profesores.clear();
    }

    public void actualizar(String codigo, String nombre, String descripcion, String local, String pabellon, String salon, Integer capacidad, EstadoLaboratorio estado) {
        dao.actualizar(codigo,nombre,descripcion,local,pabellon,salon,capacidad,estado);
    }

}
