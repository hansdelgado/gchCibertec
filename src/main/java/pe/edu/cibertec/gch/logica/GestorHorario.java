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
            String apellidoPaterno, String apellidoMaterno, TipoBusqueda tipoBusqueda) {
        List<Horario> encontrados = new LinkedList<>();
        for (Horario horario : listarTodos()) {
            switch (tipoBusqueda) {
                case Completa:
                    /*if (apellidoPaterno.equalsIgnoreCase(horario.getApellidoPaterno())
                            || apellidoMaterno.equalsIgnoreCase(horario.getApellidoMaterno())
                            || nombres.equalsIgnoreCase(horario.getNombres())) {
                        encontrados.add(horario);
                    }*/
                    break;
                case Parcial:
                    /*if ((!apellidoPaterno.isEmpty() && horario.getApellidoPaterno().contains(apellidoPaterno))
                            || (!apellidoMaterno.isEmpty() && horario.getApellidoMaterno().contains(apellidoMaterno))
                            || (!nombres.isEmpty() && horario.getNombres().contains(nombres))) {
                        encontrados.add(horario);
                    }*/
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
