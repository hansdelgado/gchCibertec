/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.modelo.mapper;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Laboratorio;

public interface LaboratorioMapper {

    Laboratorio obtenerProfesorXCodigo(String codigo);
    List<Laboratorio> obtenerProfesores();
    void insertar(Laboratorio profesor);
    void modificar(Laboratorio profesor);
    void eliminar(Laboratorio profesor);
}
