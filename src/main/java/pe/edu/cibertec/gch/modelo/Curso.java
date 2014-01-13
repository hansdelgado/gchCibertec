package pe.edu.cibertec.gch.modelo;

import java.io.Serializable;

/**
 * Es el conjunto de temas agrupados para ser dictados dentro de un tiempo
 * acordado. Puede estar asociado a distintos programas en el tiempo.
 */
public class Curso implements Serializable  {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String objetivos;
    private String requisitos;
    private String duracion;
    private EstadoCurso estado;

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
//        if (codigo == null || codigo.matches("px[a-z]{6}\\d?")) {
//            this.codigo = codigo;
//        }
    }
    
    public Curso conCodigo(String codigo) {
        setCodigo(codigo);
        return this;
    }
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Curso conNombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Curso conDescripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
    
    public Curso conObjetivos(String objetivos) {
        setObjetivos(objetivos);
        return this;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }
    
    public Curso conRequisitos(String requisitos) {
        setRequisitos(requisitos);
        return this;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Curso conDuracion(String duracion) {
        setDuracion(duracion);
        return this;
    }
    
    public EstadoCurso getEstado() {
        return estado;
    }

    public void setEstado(EstadoCurso estado) {
        this.estado = estado;
    }
    
    public Curso conEstado(EstadoCurso estado) {
        setEstado(estado);
        return this;
    }   
    
    //ESTO ES LO ULTIMO QUE ADICIONE
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Curso)) {
            return false;
        }
        final Curso other = (Curso) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
    
}
