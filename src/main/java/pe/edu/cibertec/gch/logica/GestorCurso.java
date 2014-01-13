/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.dao.cursos.CursoDao;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDao;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.EstadoCurso;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA-ADV-LM
 */
public class GestorCurso {

    private CursoDao cursodao = FactoryDao.getInstance().getCursoDao();
    
    public List<Curso> listarSegunCurso(String codigo,
            String nombre, String descripcion ,TipoBusqueda tipoBusqueda) {
        List<Curso> encontrados = new LinkedList<>();
        for (Curso curso : listarTodos()) {
            switch (tipoBusqueda) {
                case Completa:
                    if ((curso.getEstado() == EstadoCurso.Activo )) {
                        encontrados.add(curso);
                    }
                    break;
                case Parcial:
                    if ((!codigo.isEmpty() && curso.getCodigo().contains(codigo))
                            || (!nombre.isEmpty() && curso.getNombre().contains(nombre))
                            || (!descripcion.isEmpty() && curso.getDescripcion().contains(descripcion))) 
                    {
                        encontrados.add(curso);
                    }
                    break;
                default:
                    break;
            }
        }
        return encontrados;
    }
  
    public List<Curso> listarTodos() {
        List<Curso> cursosActivos = new ArrayList();
        for (Curso curso : cursodao.listarTodos()) {
            if (curso.getEstado().equals(EstadoCurso.Activo)){
                cursosActivos.add(curso);
            }

        }
        return cursosActivos;
    }
    
    public void eliminarPorCodigo(String codigo) throws DatosInvalidosException  {
        Curso cursoAEliminar = consultarPorCodigo(codigo);
        cursoAEliminar.setEstado(EstadoCurso.Inactivo);
    }

    public Curso consultarPorCodigo(final String codigo) {
        return cursodao.consultarPorCodigo(codigo);
    }
    
    public void registrar(Curso curso) {
        cursodao.registrar(curso);
    }
        
    public void actualizar(Curso curso) {
        cursodao.actualizar(curso);
    }
    
}
