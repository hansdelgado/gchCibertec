/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.List;
import pe.edu.cibertec.gch.dao.cursos.CursoDao;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Curso;

/**
 *
 * @author JAVA-ADV-LM
 */
public class GestorCurso implements GestorBase<Curso> {

    //private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    FactoryDao factoryDao = FactoryDao.getInstance();
    CursoDao cursodao = factoryDao.getCursoDao();
    
    @Override
    public List<Curso> listarTodos() {
        //throw new UnsupportedOperationException("Not supported yet.");
//        Curso c = new Curso();
//        c.setCodigo("12345");
//        cursos.add(c);
//        return cursos;
        return cursodao.listarTodos();
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        //throw new UnsupportedOperationException("Not supported yet.");
        cursodao.eliminarPorCodigo(codigo);
    }

    @Override
    public Curso consultarPorCodigo(String codigo) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return cursodao.consultarPorCodigo(codigo);
    }

    @Override
    public void registrar(Curso curso) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //cursos.add(entidad);
        
        cursodao.registrar(curso);
                
    }
    
}