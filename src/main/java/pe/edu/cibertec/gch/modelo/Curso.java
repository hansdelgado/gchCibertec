package pe.edu.cibertec.gch.modelo;

/**
 * Es el conjunto de temas agrupados para ser dictados dentro de un tiempo
 * acordado. Puede estar asociado a distintos programas en el tiempo.
 */
public class Curso {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String objetivos;
    private String requisitos;
    //private int duracion;
    private String duracion;
    private EstadoActividad estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    
    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }
    
    public Curso conEstado(EstadoActividad estado) {
        setEstado(estado);
        return this;
    }   
    
}
