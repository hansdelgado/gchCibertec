/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao.horario;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoHorario;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author LIBIO
 */
public class HorarioDaoImplMemoria implements HorarioDao{

    private static ArrayList<Horario> horarios = new ArrayList<Horario>();
    
    @Override
    public void eliminarPorCodigo(String codigo) {
       Horario horario = consultarPorCodigo(codigo);
        horario.setEstado(EstadoHorario.Inactivo);
    }

    @Override
    public Horario consultarPorCodigo(final String codigo) {
        Horario horario = new Horario() {{setCodigo(codigo);}};
        return horarios.get(horarios.indexOf(horario));
    }

    @Override
    public List<Horario> listarSegun(String nombre, String apellidoPaterno, String apellidoMaterno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Horario horario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrar(Horario horario) {
        horarios.add(horario);
    }

    @Override
    public List<Horario> listarTodos() {
         return horarios;
    }

    @Override
    public void borrarTodos() {
       horarios.clear();
    }
    
}
