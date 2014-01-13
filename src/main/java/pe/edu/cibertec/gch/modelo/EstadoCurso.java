/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.modelo;

/**
 *
 * @author ferna012
 */
public enum EstadoCurso {
    
     /**
     * El curso se encuentra con disponibilidad, o se encuentra dictando.
     */
    Activo("1"),
    /**
     * El curso no se encuentra en la institucion o esta suspendido.
     */
    Inactivo("2");

    public static EstadoCurso obtenerSegun(String estado) {
        switch (estado) {
            case "1":
                return Activo;
            case "2":
                return Inactivo;
            default:
                return Activo;
        }
    }
    
    private String estado;
    
    EstadoCurso(String estado) {
        this.estado = estado;
    }
    
    public String getEstadoCode() {
        return this.estado;
    }

}
