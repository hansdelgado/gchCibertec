package pe.edu.cibertec.gch.dao.laboratorio;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
/**
 *
 * @author Student
 */
public class LaboratorioDaoImpl implements LaboratorioDao {

    private static ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
  
    
    static {
        Laboratorio lab;
        lab=new Laboratorio();
        lab.setCodigo("10001");
        lab.setNombre("Lab1");
        lab.setDescripcion("Java");
        lab.setLocal("LOCAL1");
        lab.setPabellon("F");
        lab.setSalon("202");
        lab.setCapacidad(33);
        lab.setEstadoString(EstadoLaboratorio.Implementado);
        laboratorios.add(lab);
        
        lab=new Laboratorio();
        lab.setCodigo("10002");
        lab.setNombre("Lab2");
        lab.setDescripcion("Java 2");
        lab.setLocal("LOCAL2");
        lab.setPabellon("F");
        lab.setSalon("202");
        lab.setCapacidad(20);
        lab.setEstadoString(EstadoLaboratorio.ConProblemas);
        laboratorios.add(lab);
        
        lab=new Laboratorio();
        lab.setCodigo("10003");
        lab.setNombre("Lab3");
        lab.setDescripcion("Java 3");
        lab.setLocal("LOCAL3");
        lab.setPabellon("F");
        lab.setSalon("205");
        lab.setCapacidad(38);
        lab.setEstadoString(EstadoLaboratorio.Implementado);
        laboratorios.add(lab);
    }
    
    @Override
    public void registrar(Laboratorio laboratorio) {
        laboratorios.add(laboratorio);
                 
    }
    
    @Override
    public void actualizar(Laboratorio laboratorio) {
        Laboratorio laboratorioOld = laboratorios.get(laboratorios.indexOf(laboratorio));
        laboratorios.remove(laboratorioOld);
        laboratorios.add(laboratorio);
        
    }
    
    @Override
    public List<Laboratorio> listarTodos() {
        List<Laboratorio> encontrados = new ArrayList<Laboratorio>();
        for(Laboratorio lab:laboratorios){
           if (lab.getEstadoString()!= EstadoLaboratorio.Deshabilitado){
           encontrados.add(lab);
           }
        }
        return encontrados;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        // Al eliminar, el estado del laboratorio
        // se cambia a inactivo
        Laboratorio laboratorio = consultarPorCodigo(codigo);
        laboratorio.setEstadoString(EstadoLaboratorio.Deshabilitado);
    }

    @Override
    public Laboratorio consultarPorCodigo(final String codigo) {
//        Laboratorio laboratorio = new Laboratorio() {{setCodigo(codigo);}};
//        return laboratorios.get(laboratorios.indexOf(laboratorio));
        Laboratorio laboratorio = new Laboratorio();
        for(Laboratorio lab:laboratorios){
                        if (codigo.equals(lab.getCodigo())) {
                            laboratorio=lab;
                            break;
                        }
                    }
        return laboratorio;
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
//                    for(Laboratorio lab:laboratorios){
//                        if (nombre.equals(lab.getNombre()) && local.equals(lab.getLocal())){
//                            encontrados.add(lab);
//                        }
//                    }
                    break;
                case Parcial :
                    for(Laboratorio lab:laboratorios){
                        if(((!nombre.isEmpty()&&lab.getNombre().contains(nombre))
                                ||(!local.isEmpty()&&lab.getLocal().contains(local)))
                                &&(lab.getEstadoString()!= EstadoLaboratorio.Deshabilitado)){
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
