/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDao;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Fernando
 */
public class GestorLaboratorioImpl implements GestorLaboratorio {
     private LaboratorioDao laboratorioDao;
    
    public GestorLaboratorioImpl() {//factorymethods
        laboratorioDao = FactoryDao
                .getFactory(FactoryDao.MYBATIS)
                .getLaboratorioDao();
    }
    @Override
     public void registrar(Laboratorio laboratorio) {
        laboratorioDao.registrar(laboratorio);
    }

    @Override
    public void actualizar(Laboratorio laboratorio) {
       laboratorioDao.actualizar(laboratorio);
    }

    @Override
    public void eliminar(String codigo) {
        laboratorioDao.eliminarPorCodigo(codigo);
    }

    @Override
    public List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda) {        
        return laboratorioDao.listarSegun(nombre, local, tipoBusqueda);
    }
    @Override
    public List<Laboratorio> listarTodos() {
        return laboratorioDao.listarTodos();
    }

    @Override
    public void borrarTodos() {
        laboratorioDao.borrarTodos();
    }

    @Override
    public void eliminarSegun(String codigo) throws DatosInvalidosException {
//        Laboratorio profesorAEliminar = consultarSegun(codigo);
//        profesorAEliminar.setEstado(EstadoProfesor.Inactivo);

    }

    @Override
    public Laboratorio consultarSegun(final String codigo) {
        return laboratorioDao.consultarPorCodigo(codigo);
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        laboratorioDao.eliminarPorCodigo(codigo);
    }
}
