/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.action.laboratorio;

import com.opensymphony.xwork2.Action;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 *
 * @author YESSY
 */
public class GestionProfesorAction extends LaboratorioBaseAction {
    public String registrar(){
        Laboratorio nuevoLaboratorio = new Laboratorio().conCodigo(codigo)
                 .conNombre(nombre)
                 .conDescripcion(descripcion)
                 .conLocal(local)
                 .conPabellon(pabellon)
                 .conSalon(salon)
                 .conCapacidad(Integer.parseInt(capacidad))
                 .conEstado(EstadoLaboratorio.obtenerSegun(estado));
                 
        gestor.registrar(nuevoLaboratorio);
        return Action.SUCCESS;
    }
    
    public String actualizar(){
        gestor.actualizar(codigo, nombre, descripcion, local,pabellon,salon,Integer.parseInt(capacidad),EstadoLaboratorio.obtenerSegun(estado));
        return Action.SUCCESS;
    }
    
    public String eliminar(){
//         try {
            gestor.eliminarPorCodigo(codigo);
            return Action.SUCCESS;
//        } catch (DatosInvalidosException ex) {
//            Logger.getLogger(pe.edu.cibertec.gch.action.profesor.GestionProfesorAction.class.getName()).log(Level.SEVERE, null, ex);
//            return Action.ERROR;
//        }
    }
}
