/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.curso;

import com.opensymphony.xwork2.Action;
import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;

/**
 *
 * @author ferna012
 */
public class EdicionCursoAction implements Action {
    
    private String codigo;
    private Curso curso;
    private GestorCurso gestorCurso = new GestorCurso();
    
    @Override
    public String execute() throws Exception {
        //curso = gestorCurso.consultarSegun(codigo);
        curso = gestorCurso.consultarPorCodigo(codigo);
        if (null == curso) {
            return INPUT;
        }
        return SUCCESS;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
}
