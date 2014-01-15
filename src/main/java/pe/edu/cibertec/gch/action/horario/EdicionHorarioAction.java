/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.horario;

import com.opensymphony.xwork2.Action;
import pe.edu.cibertec.gch.logica.GestorHorario;
import pe.edu.cibertec.gch.modelo.Horario;
/**
 *
 * @author LIBIO
 */
public class EdicionHorarioAction implements Action{
    private String codigo;
    private Horario horario;
    private GestorHorario gestorHorario=new GestorHorario();

    @Override
    public String execute() throws Exception {
        horario = gestorHorario.consultarSegun(codigo);
        if (null == horario) {
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

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public GestorHorario getGestorHorario() {
        return gestorHorario;
    }

    public void setGestorHorario(GestorHorario gestorHorario) {
        this.gestorHorario = gestorHorario;
    }
    
    
            
}
