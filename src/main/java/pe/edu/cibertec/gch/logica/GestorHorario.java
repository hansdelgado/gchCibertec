/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.horario.HorarioDao;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author LIBIO
 */
public class GestorHorario {
    
    private HorarioDao horarioDao = FactoryDao.getInstance().getHorarioDao();
            
    public void registrar(Horario horario) {
        horarioDao.registrar(horario);
    }

    public void actualizar(Horario horario) {
        horarioDao.actualizar(horario);
    }
    
    public Horario Recuperar(String codigo){
        Horario h=new Horario();
        for (Horario horario : listarTodos()) {
            
                    if(codigo.equalsIgnoreCase(horario.getCodigo()))                            
                    {
                        h=horario;
                    }                     
         
        }
        return h;
    }

    public void eliminar(Horario horario) {
        horarioDao.eliminarPorCodigo(horario.getCodigo());
    }

    public List<Horario> listarSegun(String codigo,String descripcion,
            String estado, TipoBusqueda tipoBusqueda) {
        List<Horario> encontrados = new LinkedList<>();
        for (Horario horario : listarTodos()) {
            switch (tipoBusqueda) {
                case Completa:
                        encontrados.add(horario);
                    break;
                case Parcial:
                    if ((!descripcion.isEmpty() && horario.getDescripcion().contains(descripcion))
                            || (!estado.isEmpty() && horario.getEstado().toString().contains(estado))
                            || (!codigo.isEmpty() && horario.getCodigo().toString().contains(codigo))
                            ) {
                        encontrados.add(horario);
                    }
                    break;
                default:
                    break;
            }
        }
        return encontrados;
    }

    public List<Horario> listarTodos() {
        return horarioDao.listarTodos();
    }

    public void borrarTodos() {
        horarioDao.borrarTodos();
    }

    public void eliminarSegun(String codigo) {
        Horario horarioAEliminar = consultarSegun(codigo);
        horarioAEliminar.setEstado(EstadoActividad.Valido);

    }

    public Horario consultarSegun(final String codigo) {
        return horarioDao.consultarPorCodigo(codigo);
    }
}
