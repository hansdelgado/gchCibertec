/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.modelo.mapper;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Laboratorio;

public interface LaboratorioMapper {

    Laboratorio obtenerLaboratorioXCodigo(String codigo);
    List<Laboratorio> obtenerLaboratorios();
    void insertar(Laboratorio laboratorio);
    void modificar(Laboratorio laboratorio);
    void eliminar(String codigo);
    public List<Laboratorio> obtenerLaboratoriosSegun(Laboratorio lab);
}
