package pe.edu.cibertec.gch.action.profesor;

import com.opensymphony.xwork2.Action;
import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;

public class EdicionProfesorAction implements Action {

    private String codigo;
    private Profesor profesor;
    private GestorProfesor gestorProfesor = new GestorProfesor();

    @Override
    public String execute() throws Exception {
        profesor = gestorProfesor.consultarSegun(codigo);
        if (null == profesor) {
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

    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public String getEstadoDropDown() {
        return this.profesor.getEstado().getEstadoCode();
    }
    
    public String getGeneroRadioButton() {
        return this.profesor.getSexo().getGeneroCode();
    }
}
