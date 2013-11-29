/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA-ADV-LM
 */
public class GestorPrograma implements GestorBase<Programa> {

    //private static ArrayList<Programa> programas = new ArrayList<Programa>();
    ProgramaDao dao = FactoryDao.getInstance().getProgramaDao();

    @Override
    public List<Programa> listarTodos() {

        return dao.listarTodos();
    }

    public List<Programa> listarSegun(String titulo, String descripcion, TipoBusqueda tipoBusqueda) {
        List<Programa> encontrados = new LinkedList<>();
        for (Programa programas : listarTodos()) {
            switch (tipoBusqueda) {
                case Completa:
                    encontrados.add(programas);
                    break;
                case Parcial:
                    if ((!titulo.isEmpty() && programas.getTitulo().contains(titulo))
                            || (!descripcion.isEmpty() && programas.getDescripcion().contains(descripcion))) {
                        encontrados.add(programas);
                    }

                    break;
                default:
                    break;
            }
        }
        return encontrados;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Programa consultarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrar(Programa entidad) {
        dao.registrar(entidad);
    }
}
