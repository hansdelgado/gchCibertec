/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.logica;

import java.util.List;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Java-ADV-LM
 */
public interface GestorLaboratorio {

    void actualizar(Laboratorio laboratorio);

    void borrarTodos();

    Laboratorio consultarSegun(final String codigo);

    void eliminar(String codigo);

    void eliminarPorCodigo(String codigo);

    void eliminarSegun(String codigo) throws DatosInvalidosException;

    List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda);

    List<Laboratorio> listarTodos();

    void registrar(Laboratorio laboratorio);
    
}
