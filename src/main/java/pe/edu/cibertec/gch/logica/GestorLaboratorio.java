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
public class GestorLaboratorio {
     private LaboratorioDao laboratorioDao;
    
    public GestorLaboratorio() {
        laboratorioDao = FactoryDao
                .getFactory(FactoryDao.MYBATIS)
                .getLaboratorioDao();
    }
     public void registrar(Laboratorio laboratorio) {
        laboratorioDao.registrar(laboratorio);
    }

    public void actualizar(Laboratorio laboratorio) {
       laboratorioDao.actualizar(laboratorio);
    }

//    public void eliminar(Laboratorio laboratorio) {
//        laboratorioDao.eliminarPorCodigo(laboratorio.getCodigo());
//    }
    
    public void eliminar(String codigo) {
        laboratorioDao.eliminarPorCodigo(codigo);
    }

    public List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda) {
        List<Laboratorio> encontrados = new LinkedList<>();
        for (Laboratorio laboratorio : listarTodos()) {
        switch (tipoBusqueda) {
                case Completa :
                   
                        if (nombre.equalsIgnoreCase(laboratorio.getNombre())
                                ||local.equalsIgnoreCase(laboratorio.getLocal())){
                            encontrados.add(laboratorio);
                        }
                    
                    break;
                case Parcial :
                         if ((!nombre.isEmpty()&&laboratorio.getNombre().contains(nombre))
                                ||!local.isEmpty()&&laboratorio.getLocal().contains(local)){
                            encontrados.add(laboratorio);
                        }
                    }
                  break;
             //   default:
            // break;
            }
        
        return encontrados;
    }
    public List<Laboratorio> listarTodos() {
        return laboratorioDao.listarTodos();
    }

    public void borrarTodos() {
        laboratorioDao.borrarTodos();
    }

    public void eliminarSegun(String codigo) throws DatosInvalidosException {
//        Laboratorio profesorAEliminar = consultarSegun(codigo);
//        profesorAEliminar.setEstado(EstadoProfesor.Inactivo);

    }

    public Laboratorio consultarSegun(final String codigo) {
        return laboratorioDao.consultarPorCodigo(codigo);
    }

    public void eliminarPorCodigo(String codigo) {
        laboratorioDao.eliminarPorCodigo(codigo);
    }
}
