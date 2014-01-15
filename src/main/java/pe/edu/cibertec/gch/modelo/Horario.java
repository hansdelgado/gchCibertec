package pe.edu.cibertec.gch.modelo;

import com.sun.xml.internal.ws.message.StringHeader;
import java.io.Serializable;

/**
 * Rango horario de dictado de un curso.
 */
public class Horario implements Serializable{

    private String codigo;
    private String descripcion;
    /**
     * Momento de inicio del horario en minutos
     */
    private int momentoInicio;
    /**
     * Momento de fin del horario en minutos
     */
    private int momentoFin;
    private EstadoActividad estado;

    public String getCodigo() {
        return codigo;
        
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Horario conCodigo(String codigo){
        setCodigo(codigo);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Horario conDescripcion(String descripcion){
        setDescripcion(descripcion);
        return this;
    }
    public int getMomentoInicio() {
        return momentoInicio;
    }

    public void setMomentoInicio(int momentoInicio) {
        this.momentoInicio = momentoInicio;
    }
    
    public Horario conMomentoInicio(int momentoInicio){
        setMomentoInicio(momentoInicio);
        return this;
    }
    
    public int getMomentoFin() {
        return momentoFin;
    }

    public void setMomentoFin(int momentoFin) {
        this.momentoFin = momentoFin;
    }

    public Horario conMomentoFin(int momentoFin){
        setMomentoFin(momentoFin);
        return this;
    }
    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }
    public Horario conEstado(EstadoActividad estado){
        setEstado(estado);
        return this;
    }
}
