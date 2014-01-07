/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao;

import java.util.List;

/**
 *
 * @author hans delgado
 */
public interface BaseDao<T> {
    void registrar(T obj);
    List<T> listarTodos();
    void borrarTodos();
    
    
}
