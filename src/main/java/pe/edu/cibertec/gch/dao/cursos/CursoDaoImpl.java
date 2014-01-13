/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao.cursos;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.EstadoCurso;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 *
 * @author JAVA-ADV-LM
 */
public class CursoDaoImpl implements CursoDao{
    private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    
        static {
        Curso c = new Curso();
        c.setCodigo("1234");
        c.setNombre("Java Basic");
        c.setDescripcion("Curso de Capacitación");
        c.setEstado(EstadoCurso.Activo);
        cursos.add(c);
        
        Curso d = new Curso();
        d.setCodigo("5678");
        d.setNombre("Java Advanced");
        d.setDescripcion("Curso de Especialización");
        d.setEstado(EstadoCurso.Activo);
        cursos.add(d);
        
        Curso e = new Curso();
        e.setCodigo("9012");
        e.setNombre("Java Framework");
        e.setDescripcion("Curso de Postgrado");
        e.setEstado(EstadoCurso.Activo);
        cursos.add(e);
        
    }

    
    @Override
    public void eliminarPorCodigo(String codigo) {
        Curso curso = consultarPorCodigo(codigo);
        curso.setEstado(EstadoCurso.Inactivo);
    }

    @Override
    public Curso consultarPorCodigo(final String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
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
    
     @Override
    public List<Curso> listarSegun(String nombre, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actualizar(Curso curso) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Curso curso2 = consultarPorCodigo(curso.getCodigo());
        curso2.setNombre(curso.getNombre());
        curso2.setDescripcion(curso.getDescripcion());
        curso2.setObjetivos(curso.getObjetivos());
        curso2.setRequisitos(curso.getRequisitos());
        curso2.setDuracion(curso.getDuracion());
        curso2.setEstado(curso.getEstado());
    }
    
}
