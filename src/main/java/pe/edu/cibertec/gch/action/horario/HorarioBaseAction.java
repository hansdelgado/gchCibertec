/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.horario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.logica.GestorHorario;
import pe.edu.cibertec.gch.modelo.Horario;
/**
 *
 * @author LIBIO
 */
public abstract class HorarioBaseAction extends ActionSupport{
    protected GestorHorario gestor = new GestorHorario();
    protected List<Horario> listaHorarios;
    
    String codigo,
            descripcion,
            estado,
            tipoBusqueda;
    int horaInicio,
            horaFin;
    
    protected static String LISTA_BASE = "listaBase";

    public GestorHorario getGestor() {
        return gestor;
    }

    public void setGestor(GestorHorario gestor) {
        this.gestor = gestor;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public static String getLISTA_BASE() {
        return LISTA_BASE;
    }

    public static void setLISTA_BASE(String LISTA_BASE) {
        HorarioBaseAction.LISTA_BASE = LISTA_BASE;
    }
    
}
