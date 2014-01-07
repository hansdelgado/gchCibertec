/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao.cursos;
import pe.edu.cibertec.gch.dao.BaseDao;
import pe.edu.cibertec.gch.modelo.Curso;

/**
 *
 * @author JAVA-ADV-LM
 */
public interface CursoDao extends BaseDao<Curso> {
    void eliminarPorCodigo(final String codigo);
    Curso consultarPorCodigo(final String codigo);
    void actualizar(Curso curso);
}
