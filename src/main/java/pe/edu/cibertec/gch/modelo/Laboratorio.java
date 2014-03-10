package pe.edu.cibertec.gch.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ambiente que contiene equipos necesarios para dictar clases.
 */
@Entity
@Table(name="LABORATORIO")
public class Laboratorio implements Serializable{

    @Id
    @Column(name="CODIGO")
    private String codigo;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    @Column(name="LOCAL")
    private String local;
    
    @Column(name="PABELLON")
    private String pabellon;
    
    @Column(name="SALON")
    private String salon;
    
    @Column(name="CAPACIDAD")
    private int capacidad;
    
    @Column(name="ESTADO")
    private Integer estado;
//    private EstadoLaboratorio estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Laboratorio conCodigo(String codigo) {
        setCodigo(codigo);
        return this;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Laboratorio conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Laboratorio conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public Laboratorio conLocal(String local) {
        this.local = local;
        return this;
    }

    public String getPabellon() {
        return pabellon;
    }

    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }

    public Laboratorio conPabellon(String pabellon) {
        this.pabellon = pabellon;
        return this;
    }
    
    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    public Laboratorio conSalon(String salon) {
        this.salon = salon;
        return this;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public Laboratorio conCapacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    public Laboratorio conEstado(Integer estado) {
        this.estado = estado;
        return this;
    }
    
    public EstadoLaboratorio getEstadoString() {
        return EstadoLaboratorio.obtenerSegun(Integer.toString(this.estado));
    }
    
    public void setEstadoString(EstadoLaboratorio estado) {
        setEstado(Integer.parseInt(EstadoLaboratorio.obtenerSegun(estado)));
    }
    
     public boolean tieneDatosObligatorios() {
        boolean faltaCodigo = (null == getCodigo()),
                faltaNombre = (null == getNombre()),
                faltaDescripcion = (null == getDescripcion()),
                faltaLocal = (null == getLocal());
        // se puede devolver directamente el resultado de la condicion,
        if (faltaCodigo
                || faltaNombre
                || faltaDescripcion
                || faltaLocal) {
            return false;
        } else {
            return true;
        }
    }
}
