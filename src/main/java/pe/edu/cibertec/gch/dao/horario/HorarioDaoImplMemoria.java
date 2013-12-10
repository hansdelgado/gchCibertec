/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao.horario;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author LIBIO
 */
public class HorarioDaoImplMemoria implements HorarioDao {

    private static ArrayList<Horario> horarios = new ArrayList<Horario>();

    static {

        Horario horariodemuestra = new Horario();
        horariodemuestra.setCodigo("3546");
        horariodemuestra.setDescripcion("java advanced");
        horariodemuestra.setMomentoFin(5);
        horariodemuestra.setMomentoInicio(1);
        horariodemuestra.setEstado(EstadoActividad.Activo);
        horarios.add(horariodemuestra);

        Horario horariodemuestra2 = new Horario();
        horariodemuestra2.setCodigo("4546");
        horariodemuestra2.setDescripcion("java");
        horariodemuestra2.setEstado(EstadoActividad.Inactivo);
        horariodemuestra2.setMomentoFin(5);
        horariodemuestra2.setMomentoInicio(1);
        horarios.add(horariodemuestra2);
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        int indexEliminar;
        indexEliminar = 999999;
        for (Horario i : horarios) {
            if (i.getCodigo().equalsIgnoreCase(codigo));
            indexEliminar = horarios.indexOf(i);
        }

        horarios.remove(horarios.get(indexEliminar));
        System.out.println("eliminando horario");
    }

    @Override
    public Horario consultarPorCodigo(String codigo) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Horario h = new Horario();
        return h;
    }

    @Override
    public List<Horario> listarSegun(String nombre, String apellidoPaterno, String apellidoMaterno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Horario horario) {

//        int indexActualizar = 9999;
//        System.out.println("entramos al bucle");
//        for (Horario i : horarios) {
//            if (i.getCodigo().equalsIgnoreCase(horario.getCodigo())) {
//                System.out.println(i.getCodigo());
//                indexActualizar = horarios.indexOf(i);
//            }
//            horarios.set(indexActualizar, horario);
//        }
        Horario actualizado = null;
        for (Horario horarioActualizado: horarios){
            if (horarioActualizado.getCodigo().equals(horario.getCodigo()))
                actualizado=horarioActualizado;
        }
        horarios.remove(actualizado);
        horarios.add(horario);
    }

    @Override
    public void registrar(Horario obj) {
        horarios.add(obj);
    }

    @Override
    public List<Horario> listarTodos() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return horarios;
    }

    @Override
    public void borrarTodos() {
        horarios.clear();
    }

    @Override
    public Horario Recuperar(String codigo) {
        return horarios.get(horarios.indexOf(codigo));
    }
}
