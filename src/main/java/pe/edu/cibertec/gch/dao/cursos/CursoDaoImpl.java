/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao.cursos;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;

/**
 *
 * @author JAVA-ADV-LM
 */
public class CursoDaoImpl implements CursoDao{
    private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    
    static {
        Curso c = new Curso();
        c.setCodigo("123456789");
        c.setNombre("Java Advanced");
        c.setDescripcion("Curso de Especialización");
        cursos.add(c);
    }
    
    @Override
    public void eliminarPorCodigo(String codigo) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Curso curso = consultarPorCodigo(codigo);
        curso.setEstado(EstadoActividad.Obsoleto);
    }

    @Override
    public Curso consultarPorCodigo(final String codigo) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Curso curso = new Curso() {{setCodigo(codigo);}};
        return cursos.get(cursos.indexOf(curso));
    }

       
    @Override
    public void registrar(Curso curso) {
        //throw new UnsupportedOperationException("Not supported yet.");
        cursos.add(curso);
        
    }

    @Override
    public List<Curso> listarTodos() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return cursos;
    }

    @Override
    public void borrarTodos() {
        //throw new UnsupportedOperationException("Not supported yet.");
        cursos.clear();
    }
    
}
