/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.action.laboratorio;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 *
 * @author YESSY
 */
public class LaboratorioBaseAction extends ActionSupport{
    //protected GestorLaboratorioImpl gestorLaboratorio= new GestorLaboratorioImpl();
    protected GestorLaboratorio gestorLaboratorio;
    protected List<Laboratorio> listaLaboratorios;
    
    String codigo;
    String nombre;
    String descripcion;
    String local;
    String pabellon;
    String salon;
    String capacidad;
    String estado;
    String tipoBusqueda;
            
    protected static String LISTA_BASE = "listaBase";

    public GestorLaboratorio getGestorLaboratorio() {
        return gestorLaboratorio;
    }

    public void setGestorLaboratorio(GestorLaboratorio gestorLaboratorio) {
        this.gestorLaboratorio = gestorLaboratorio;
    }
    
    public List<Laboratorio> getListaLaboratorios() {
        return listaLaboratorios;
    }

    public void setListaLaboratorios(List<Laboratorio> listaLaboratorios) {
        this.listaLaboratorios = listaLaboratorios;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPabellon() {
        return pabellon;
    }

    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static String getLISTA_BASE() {
        return LISTA_BASE;
    }

    public static void setLISTA_BASE(String LISTA_BASE) {
        LaboratorioBaseAction.LISTA_BASE = LISTA_BASE;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }        
}
