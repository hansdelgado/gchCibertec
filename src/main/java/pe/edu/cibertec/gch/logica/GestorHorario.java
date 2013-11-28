/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.horario.HorarioDao;
import pe.edu.cibertec.gch.modelo.EstadoHorario;
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

    public void eliminar(Horario horario) {
        horarioDao.eliminarPorCodigo(horario.getCodigo());
    }

    public List<Horario> listarSegun(String nombres,
            String descripcion, String estado, TipoBusqueda tipoBusqueda) {
        List<Horario> encontrados = new LinkedList<>();
        for (Horario horario : listarTodos()) {
            switch (tipoBusqueda) {
                case Completa:
                    if (descripcion.equalsIgnoreCase(horario.getDescripcion())
                            || estado.equalsIgnoreCase(horario.getEstado().toString())
                            ) {
                        encontrados.add(horario);
                    }
                    break;
                case Parcial:
                    if ((!descripcion.isEmpty() && horario.getDescripcion().contains(descripcion))
                            || (!estado.isEmpty() && horario.getEstado().toString().contains(estado))
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
        horarioAEliminar.setEstado(EstadoHorario.Inactivo);

    }

    public Horario consultarSegun(final String codigo) {
        return horarioDao.consultarPorCodigo(codigo);
    }
}