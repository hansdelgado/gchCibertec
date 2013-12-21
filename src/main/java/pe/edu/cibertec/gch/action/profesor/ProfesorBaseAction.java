/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.action.profesor;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 *
 * @author hans delgado
 */
public abstract class ProfesorBaseAction extends ActionSupport {
    
    protected GestorProfesor gestor = new GestorProfesor();
    protected List<Profesor> listaProfesores;
    
    String codigo,
            nombres,
            apellidoPaterno,
            apellidoMaterno,
            direccion,
            referencia,
            fechaNacimiento,
            sexo,
            estado,
            tipoBusqueda;
    
    protected static String LISTA_BASE = "listaBase";

    public static String getLISTA_BASE() {
        return LISTA_BASE;
    }

    public static void setLISTA_BASE(String aLISTA_BASE) {
        LISTA_BASE = aLISTA_BASE;
    }
    
public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public GestorProfesor getGestor() {
        return gestor;
    }

    public void setGestor(GestorProfesor gestor) {
        this.gestor = gestor;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }    
}
