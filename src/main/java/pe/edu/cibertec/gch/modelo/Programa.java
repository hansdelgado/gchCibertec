package pe.edu.cibertec.gch.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Conjunto de cursos asociados con respecto a un objetivo de ensenanza.
 */
public class Programa {

    private String codigo;
    private String titulo;
    private String descripcion;
    private String objetivos;
    private String requisitos;
    private Moneda moneda;
    private double precio;
    private EstadoActividad estado;
    private Date fechaInicial;
    private int duracion;

    public Programa() {
    }

    public Programa(String codigo) {
        this.codigo = codigo;
    }

    public Programa(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public Programa(String codigo, String titulo, String descripcion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getFechaInicial() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fechaInicial);
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Programa conCodigo(String codigo) {
        setCodigo(codigo);
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Programa conTitulo(String titulo) {
        setTitulo(titulo);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Programa conDescripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public Programa conObjetivos(String objetivos) {
        setObjetivos(objetivos);
        return this;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Programa conRequisitos(String requisitos) {
        setRequisitos(requisitos);
        return this;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public String getMonedaStr() {
        if (moneda == Moneda.NuevosSoles) {
            return "NS";
        } else if (moneda == Moneda.DolaresUS) {
            return "D";
        } else {
            return "";
        }
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Programa conPrecio(double precio) {
        setPrecio(precio);
        return this;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public Programa conEstado(EstadoActividad estado) {
        setEstado(estado);
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programa other = (Programa) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
}
