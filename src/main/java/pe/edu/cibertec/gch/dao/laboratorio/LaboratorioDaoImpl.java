package pe.edu.cibertec.gch.dao.laboratorio;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.util.UnescapeUtil;

/**
 *
 * @author Student
 */
public class LaboratorioDaoImpl implements LaboratorioDao {

    private static ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
    
    static {
        Laboratorio lab;
        lab=new Laboratorio();
        lab.setCodigo("1244");
        lab.setNombre("Lab Cibertec");
        lab.setLocal("LOCAL1");
        laboratorios.add(lab);
        
        lab=new Laboratorio();
        lab.setCodigo("1245");
        lab.setNombre("Lab 2");
        lab.setLocal("LOCAL2");
        laboratorios.add(lab);
        
        lab=new Laboratorio();
        lab.setCodigo("1246");
        lab.setNombre("Lab 3");
        lab.setLocal("LOCAL2");
        laboratorios.add(lab);
    }
    
    @Override
    public void registrar(Laboratorio laboratorio) {
        laboratorios.add(laboratorio);
    }

    @Override
    public List<Laboratorio> listarTodos() {
        return laboratorios;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        // Al eliminar, el estado del profesor 
        // se cambia a inactivo
        Laboratorio laboratorio = consultarPorCodigo(codigo);
        laboratorio.setEstado(EstadoLaboratorio.Deshabilitado);
    }

    @Override
    public void modificarPorCodigo(String codigo, String nombre,String descripcion,String local ) {
//        String pabellon,String salon,int capacidad
        Laboratorio laboratorio = consultarPorCodigo(codigo);
        laboratorio.setNombre(nombre);
        laboratorio.setDescripcion(descripcion);
        laboratorio.setLocal(local);
//        laboratorio.setPabellon(pabellon);
//        laboratorio.setSalon(salon);
//        laboratorio.setCapacidad(capacidad);
    }
    
    @Override
    public Laboratorio consultarPorCodigo(final String codigo) {
        Laboratorio laboratorio = new Laboratorio() {{setCodigo(codigo);}};
        return laboratorios.get(laboratorios.indexOf(laboratorio));
    }

    @Override
    public void borrarTodos() {
        laboratorios.clear();
    }

    @Override
    public List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda) {
        List<Laboratorio> encontrados = new ArrayList<Laboratorio>();
        
        switch (tipoBusqueda) {
                case Completa :
                    encontrados=listarTodos();
                    break;
                case Parcial :
                    for(Laboratorio lab:laboratorios){                        
                        
                        if (nombre.equals(lab.getNombre()) ||local.equals(lab.getLocal())){
                            encontrados.add(lab);
                        }
                    }
                    break;
                default:
                    break;
        } 
        return encontrados;
    }
    
}
