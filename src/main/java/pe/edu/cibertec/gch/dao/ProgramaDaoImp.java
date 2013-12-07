/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

public class ProgramaDaoImp implements ProgramaDao {

    private static ArrayList<Programa> programas = new ArrayList<Programa>();

    static {
        Programa p = new Programa();
        p.setCodigo("01");
        p.setDescripcion("descripcion");
        p.setTitulo("nombre");
        p.setObjetivos("obj");

        programas.add(p);
    }

    @Override
    public List<Programa> listarTodos() {

        return programas;
    }

    @Override
    public void registrar(Programa programa) {
        programas.add(programa);
    }

    public void borrarTodos() {
    }

    @Override
    public List<Programa> listarSegun(String titulo, String descripcion, String objetivo, TipoBusqueda tipoBusqueda) {
        return null;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        programas.remove(new Programa(codigo));
    }

    @Override
    public Programa consultarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
